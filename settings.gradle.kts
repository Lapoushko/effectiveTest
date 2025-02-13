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

rootProject.name = "effectiveTest"
include(":app")
include(":domain")
include(":data")
include(":data:network")
include(":data:storage")
include(":feature")
include(":feature:favourite")
include(":feature:home")
include(":feature:selection")
include(":common")
include(":feature:profile")
include(":feature:respond")
include(":feature:message")
include(":feature:detail")
