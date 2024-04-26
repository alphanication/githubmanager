plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger)
}

android {
    namespace = "com.alphanication.githubmanager"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.alphanication.githubmanager"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    viewBinding {
        enable = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":feature_search_repo_by_user:presentation"))
    implementation(project(":feature_downloads_repo:presentation"))

    implementation(libs.dagger.hilt)
    kapt(libs.dagger.compiler)

    implementation(libs.bundles.material)
    implementation(libs.bundles.screens)
    implementation(libs.bundles.navigation)

    implementation(libs.bundles.viewmodel)
    implementation(libs.kotlin.coroutines.android)
}