pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://maven.google.com") }
        maven { url = uri("https://maven.fabric.io/public") }
        maven { url = uri("https://jitpack.io") }
    }
}
rootProject.name = "BookMark"

include(":presentation", ":domain",":di",":local",":remote",":data")
