import org.gradle.api.artifacts.dsl.DependencyHandler


object Libraries {

    val GRADLE = "com.android.tools.build:gradle:7.4.1"
    val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20"
    val NAVIGATION = "androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3"

    //Android
    private val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.APP_COMPAT}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.CORE_KTX}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}"
    private val material = "com.google.android.material:material:1.8.0"
    private val activityKtx = "androidx.activity:activity-ktx:1.7.0"
    private val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.6"
    private val glide = "com.github.bumptech.glide:glide:4.14.2"
    private val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.5.3"
    private val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:2.5.3"

    //Test
    private val junit = "junit:junit:4.13.2"

    //AndroidTest
    private val testJunit = "androidx.test.ext:junit:1.1.5"
    private val espresso = "androidx.test.espresso:espresso-core:3.5.1"

    //Network
    private val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    private val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
    private val okhttp3 = "com.squareup.okhttp3:okhttp:4.10.0"
    private val okhttp3LogginInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.0"

    //Kapt
    private val glideCompiler = "com.github.bumptech.glide:compiler:4.13.0"
    private val hiltCompiler = "com.google.dagger:hilt-android-compiler:2.44"
    private val roomCompiler = "androidx.room:room-compiler:2.5.1"

    //Async
    private val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"

    //DI
    private val hilt = "com.google.dagger:hilt-android:2.44"

    //Room
    private val roomKtx = "androidx.room:room-ktx:2.5.1"
    private val roomRuntime = "androidx.room:room-runtime:2.5.1"


    val async = arrayListOf<String>().apply{
        add(coroutines)
    }

    val di = arrayListOf<String>().apply {
        add(hilt)
    }

    val app = arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
        add(material)
        add(activityKtx)
        add(fragmentKtx)
        add(glide)
        add(navigationFragmentKtx)
        add(navigationUiKtx)
        add(constraintLayout)
    }

    val test = arrayListOf<String>().apply{
        add(junit)
    }

    val androidTest = arrayListOf<String>().apply{
        add(testJunit)
        add(espresso)
    }

    val room = arrayListOf<String>().apply {
        add(roomKtx)
        add(roomRuntime)
    }

    val network = arrayListOf<String>().apply {
        add(retrofit)
        add(gsonConverter)
        add(okhttp3)
        add(okhttp3LogginInterceptor)
    }

    val kapt = arrayListOf<String>().apply {
        add(glideCompiler)
        add(hiltCompiler)
        add(roomCompiler)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)

    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}