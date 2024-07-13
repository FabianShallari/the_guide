package theguide.modules.autobind.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.ksp.toClassName
import com.squareup.kotlinpoet.ksp.toTypeName
import com.squareup.kotlinpoet.ksp.writeTo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import theguide.modules.autobind.annotations.AutoBind
import kotlin.reflect.KClass

class BindModuleCodeGenerator(
    private val logger: KSPLogger,
    private val codeGenerator: CodeGenerator
) {
    fun generateBindModule(classDeclaration: KSClassDeclaration) {
        FileSpec.builder(
            packageName = classDeclaration.packageName.asString(),
            fileName = daggerModuleNameFor(classDeclaration)
        )
            .addType(typeSpec = moduleClassSpec(classDeclaration))
            .build()
            .writeTo(
                codeGenerator = codeGenerator,
                aggregating = false,
                originatingKSFiles = listOf(requireNotNull(classDeclaration.containingFile))
            )

    }

    private fun moduleClassSpec(classDeclaration: KSClassDeclaration): TypeSpec {
        return TypeSpec.classBuilder(daggerModuleNameFor(classDeclaration))
            .addModifiers(KModifier.ABSTRACT)
            .addAnnotation(AnnotationSpec.builder(Module::class).build())
            .addAnnotation(
                AnnotationSpec
                    .builder(InstallIn::class)
                    .addMember(classDeclaration.valueOfAutoBindComponentArg())
                    .build()
            )
            .addFunction(bindFunctionSpec(classDeclaration))
            .build()
    }

    private fun KSClassDeclaration.valueOfAutoBindComponentArg(): CodeBlock {
        val components = this
            .findAnnotation(AutoBind::class)
            .arguments
            .first()
            .value as ArrayList<KSType>

        return CodeBlock.of(
            format = "value = \n⇥${components.map { "%T::class" }}⇤\n",
            args = components.classNames(),
        )
    }

    private fun bindFunctionSpec(classDeclaration: KSClassDeclaration): FunSpec {
        return FunSpec
            .builder("bind${classDeclaration.superTypes.first().resolve().toClassName().simpleName}")
            .addModifiers(KModifier.INTERNAL, KModifier.ABSTRACT)
            .addAnnotation(Binds::class)
            .addParameter(
                name = "impl",
                type = classDeclaration.toClassName()
            )
            .returns(classDeclaration.superTypes.first().toTypeName())
            .build()
    }

    private fun daggerModuleNameFor(classDeclaration: KSClassDeclaration): String {
        return "${classDeclaration.superTypes.first().resolve().toClassName().simpleName}Module"
    }

    private fun List<KSType>.classNames(): Array<ClassName> =
        map { it.toClassName() }.toTypedArray<ClassName>()

    private fun KSClassDeclaration.findAnnotation(klass: KClass<*>): KSAnnotation {
        return annotations
            .first { it.annotationType.resolve().toClassName() == klass.asClassName() }
    }
}
