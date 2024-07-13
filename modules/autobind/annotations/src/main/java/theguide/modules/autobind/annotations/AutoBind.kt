package theguide.modules.autobind.annotations

import dagger.hilt.GeneratesRootInput
import dagger.hilt.components.SingletonComponent
import kotlin.reflect.KClass

@Suppress("RedundantVisibilityModifier")
@GeneratesRootInput
@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
public annotation class AutoBind(
    /**
     * The Hilt components in which the generated module will be installed in.
     */
    val components: Array<KClass<*>> = [SingletonComponent::class],
)
