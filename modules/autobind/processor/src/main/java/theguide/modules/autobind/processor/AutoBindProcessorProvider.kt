package theguide.modules.autobind.processor

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class AutoBindProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        AutoBindProcessor(
            logger = environment.logger,
            bindModuleCodeGenerator = BindModuleCodeGenerator(
                environment.logger,
                environment.codeGenerator
            ),
        )
}
