pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
rootProject.name = "BookMark"


include(":presentation", ":domain",":di",":local",":remote",":data")
