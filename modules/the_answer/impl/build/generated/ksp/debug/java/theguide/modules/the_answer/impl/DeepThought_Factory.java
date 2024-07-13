package theguide.modules.the_answer.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import theguide.modules.the_union_of_philosophers.api.TheUnionOfPhilosophers;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DeepThought_Factory implements Factory<DeepThought> {
  private final Provider<TheUnionOfPhilosophers> theUnionOfPhilosophersProvider;

  public DeepThought_Factory(Provider<TheUnionOfPhilosophers> theUnionOfPhilosophersProvider) {
    this.theUnionOfPhilosophersProvider = theUnionOfPhilosophersProvider;
  }

  @Override
  public DeepThought get() {
    return newInstance(theUnionOfPhilosophersProvider.get());
  }

  public static DeepThought_Factory create(
      Provider<TheUnionOfPhilosophers> theUnionOfPhilosophersProvider) {
    return new DeepThought_Factory(theUnionOfPhilosophersProvider);
  }

  public static DeepThought newInstance(TheUnionOfPhilosophers theUnionOfPhilosophers) {
    return new DeepThought(theUnionOfPhilosophers);
  }
}
