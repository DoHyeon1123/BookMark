plugins {
    kotlin("kapt")
    id("com.android.library")
    id("kotlin-android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.bookmark.data"
    compileSdk = 33


    defaultConfig {
        minSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

    kotlinOptions {
        jvmTarget = "18"
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Libraries.di)
    implementation(Libraries.async)
    implementation(Libraries.room)
    implementation(Libraries.network)

    testImplementation(Libraries.test)
    androidTestImplementation(Libraries.androidTest)

    kapt(Libraries.hiltCompiler)
    kapt(Libraries.glideCompiler)
    kapt(Libraries.roomCompiler)


}