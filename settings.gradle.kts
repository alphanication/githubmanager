pluginManagement {
    repositories {
        google()
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

rootProject.name = "githubmanager"
include(":app")
include(":feature_search_repo_by_user")
include(":feature_search_repo_by_user:presentation")
include(":feature_search_repo_by_user:data")
include(":feature_search_repo_by_user:domain")
include(":feature_downloads_repo")
include(":feature_downloads_repo:presentation")
include(":core")
include(":core:data")
include(":core:domain")
include(":core:presentation")
include(":feature_search_repo_by_user:di")
