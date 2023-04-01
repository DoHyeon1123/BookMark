// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
    }
}

plugins {
    id("com.android.application") version "7.4.1" apply false
    id ("com.android.library") version "7.4.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.21" apply false
    id ("org.jetbrains.kotlin.jvm") version "1.7.0" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}