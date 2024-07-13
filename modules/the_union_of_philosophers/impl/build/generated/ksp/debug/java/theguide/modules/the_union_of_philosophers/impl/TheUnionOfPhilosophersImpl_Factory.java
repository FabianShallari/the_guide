package theguide.modules.the_union_of_philosophers.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class TheUnionOfPhilosophersImpl_Factory implements Factory<TheUnionOfPhilosophersImpl> {
  @Override
  public TheUnionOfPhilosophersImpl get() {
    return newInstance();
  }

  public static TheUnionOfPhilosophersImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TheUnionOfPhilosophersImpl newInstance() {
    return new TheUnionOfPhilosophersImpl();
  }

  private static final class InstanceHolder {
    private static final TheUnionOfPhilosophersImpl_Factory INSTANCE = new TheUnionOfPhilosophersImpl_Factory();
  }
}
