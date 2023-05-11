plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.bookmark.presentation"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.bookmark.presentation"
        minSdk = 31
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    dataBinding {
        enable = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Libraries.app)
    testImplementation(Libraries.test)
    androidTestImplementation(Libraries.androidTest)
    implementation(Libraries.di)
    implementation(Libraries.async)
    kapt(Libraries.kapt)

}

kapt {
    correctErrorTypes = true
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven { url = uri("https://maven.google.com") }
    maven { url = uri("https://maven.fabric.io/public") }
    maven { url = uri("https://jitpack.io") }
}
