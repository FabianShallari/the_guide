package theguide.modules.the_union_of_philosophers.`impl`

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import theguide.modules.the_union_of_philosophers.api.TheUnionOfPhilosophers

@Module
@InstallIn(value = 
  [SingletonComponent::class]
)
public abstract class TheUnionOfPhilosophersModule {
  @Binds
  internal abstract fun bindTheUnionOfPhilosophers(`impl`: TheUnionOfPhilosophersImpl):
      TheUnionOfPhilosophers
}
