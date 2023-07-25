plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    kotlin("kapt")
}

kotlin {
    jvmToolchain(11)
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
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
    dataBinding {
        enable = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":di"))

    implementation(platform("com.google.firebase:firebase-bom:32.2.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")

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