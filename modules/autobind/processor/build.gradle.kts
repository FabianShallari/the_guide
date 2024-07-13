plugins {
    id("org.jetbrains.kotlin.jvm")
    alias(libs.plugins.ksp)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


dependencies {
    api(project(":modules:autobind:annotations"))

    api(libs.hilt.core)

    implementation(libs.kotlin.ksp)
    implementation(libs.kotlinpoet)
    implementation(libs.kotlinpoet.ksp)
}
