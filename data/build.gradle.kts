plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.bookmark.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":local"))
    implementation(project(":remote"))

    testImplementation(Libraries.test)
    androidTestImplementation(Libraries.androidTest)
    implementation(Libraries.di)
    implementation(Libraries.async)
    kapt(Libraries.kapt)
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven { url = uri("https://maven.google.com") }
    maven { url = uri("https://maven.fabric.io/public") }
    maven { url = uri("https://jitpack.io") }
}