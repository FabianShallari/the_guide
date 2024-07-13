package theguide.modules.the_answer.`impl`

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import theguide.modules.the_answer.api.TheAnswerCalculator

@Module
@InstallIn(value = 
  [SingletonComponent::class]
)
public abstract class TheAnswerCalculatorModule {
  @Binds
  internal abstract fun bindTheAnswerCalculator(`impl`: DeepThought): TheAnswerCalculator
}
