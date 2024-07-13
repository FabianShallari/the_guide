pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TheGuide"
include(
    ":app",
    ":modules:the_answer:api",
    ":modules:the_answer:impl",
    ":modules:the_union_of_philosophers:api",
    ":modules:the_union_of_philosophers:impl",
    ":modules:autobind:annotations",
    ":modules:autobind:processor"
)
