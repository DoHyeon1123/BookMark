import org.gradle.api.artifacts.dsl.DependencyHandler


object Libraries {

    //Android
    private val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.APP_COMPAT}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.CORE_KTX}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}"
    private val material = "com.google.android.material:material:${Versions.Google.MATERIAL}"
    private val activityKtx = "androidx.activity:activity-ktx:${Versions.AndroidX.ACTIVITY_KTX}"
    private val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.AndroidX.FRAGMENT_KTX}"
    private val glide = "com.github.bumptech.glide:glide:${Versions.ThirdParty.GLIDE}"
    private val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.NAVIGATION}"
    private val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.NAVIGATION}"
    private val circleImageView = "de.hdodenhof:circleimageview:3.1.0" //Circle ImageView
    private val coordinatorlayout =  "androidx.coordinatorlayout:coordinatorlayout:1.1.0"

    //Firebase
    val firebase_bom = "com.google.firebase:firebase-bom:${Versions.Google.FIREBASE_BOM}"
    private val firebase_analytics = "com.google.firebase:firebase-analytics-ktx"
    private val firevase_database = "com.google.firebase:firebase-database-ktx"

    //Test
    private val junit = "junit:junit:${Versions.Test.JUNIT}"

    //AndroidTest
    private val testJunit = "androidx.test.ext:junit:${Versions.AndroidTest.TEST_JUNIT}"
    private val espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidTest.ESPRESSO}"

    //Network
    private val retrofit = "com.squareup.retrofit2:retrofit:${Versions.ThirdParty.RETROFIT}"
    private val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.ThirdParty.RETROFIT}"
    private val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.ThirdParty.OKHTTP3}"
    private val okhttp3LogginInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.ThirdParty.OKHTTP3}"

    //Kapt
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.ThirdParty.GLIDE}"
    val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Google.HILT}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.AndroidX.ROOM}"


    //Async
    private val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Jetbrains.COROUTINES}"

    //DI
    private val hilt = "com.google.dagger:hilt-android:${Versions.Google.HILT}"

    //Room
    private val roomKtx = "androidx.room:room-ktx:${Versions.AndroidX.ROOM}"
    private val roomRuntime = "androidx.room:room-runtime:${Versions.AndroidX.ROOM}"

    val common = arrayListOf<String>().apply {
        add(coroutines)
        add(hilt)
    }

    val test = arrayListOf<String>().apply {
        add(junit)
    }

    val androidTest = arrayListOf<String>().apply {
        add(testJunit)
        add(espresso)
    }

    val presentation = arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
        add(material)
        add(activityKtx)
        add(fragmentKtx)
        add(glide)
        add(navigationFragmentKtx)
        add(navigationUiKtx)
        add(constraintLayout)
        add(circleImageView)
        add(coordinatorlayout)
    }

    val data = arrayListOf<String>().apply {
        add(firebase_analytics)
        add(firevase_database)
        add(roomKtx)
        add(roomRuntime)
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