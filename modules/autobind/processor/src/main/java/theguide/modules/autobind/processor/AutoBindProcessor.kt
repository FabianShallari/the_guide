package theguide.modules.autobind.processor

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import theguide.modules.autobind.annotations.AutoBind

class AutoBindProcessor(
    private val logger: KSPLogger,
    private val bindModuleCodeGenerator: BindModuleCodeGenerator,
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {

        resolver
            .getSymbolsWithAnnotation(requireNotNull(AutoBind::class.qualifiedName))
            .filterIsInstance<KSClassDeclaration>()
            .forEach { bindModuleCodeGenerator.generateBindModule(it) }

        return emptyList()
    }
}
