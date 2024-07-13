plugins {
    id("com.android.library")
    alias(libs.plugins.ksp)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "theguide.modules.the_union_of_philosophers.impl"
    compileSdk = 34

    kotlinOptions {
        jvmTarget = "17"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    api(project(":modules:the_union_of_philosophers:api"))
    implementation(project(":modules:autobind:annotations"))

    implementation(libs.hilt.android)
    implementation(libs.androidx.core.ktx)

    ksp(libs.hilt.compiler)
    ksp(project(":modules:autobind:processor"))
}