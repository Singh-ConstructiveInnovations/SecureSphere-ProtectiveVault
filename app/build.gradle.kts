plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.secure.sphere.privacy.protective.vault"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.secure.sphere.privacy.protective.vault"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    /*todo: XML Related Dependencies*/
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    /*todo: XML Related Dependencies*/

    /*todo: Compose Related Dependencies*/
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2024.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    /*todo: Compose Related Dependencies*/

    /*todo: Navigation Components */
    val navVersion = "2.8.3"
    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$navVersion")
    /*todo: Navigation Components */

    //todo: Dependency Injection - Dagger HILT
    implementation("com.google.dagger:hilt-android:2.52")
    ksp("com.google.dagger:hilt-android-compiler:2.52")

    //todo: Data Store
    implementation("androidx.datastore:datastore:1.1.1") // Proto
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    //todo: WorkManager
    val workVersion = "2.10.0"
    implementation("androidx.work:work-runtime-ktx:$workVersion")
    androidTestImplementation("androidx.work:work-testing:$workVersion")

    //todo: Media3 Player
    val media3Version = "1.4.1"
    implementation("androidx.media3:media3-exoplayer:$media3Version") // For media playback using ExoPlayer
    implementation("androidx.media3:media3-exoplayer-dash:$media3Version") // For DASH playback support with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-hls:$media3Version") // For HLS playback support with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-smoothstreaming:$media3Version") // For SmoothStreaming playback support with ExoPlayer
    implementation("androidx.media3:media3-ui:$media3Version")  // For building media playback UIs
    implementation("androidx.media3:media3-session:$media3Version") // For exposing and controlling media sessions
    implementation("androidx.media3:media3-extractor:$media3Version") // For extracting data from media containers
    implementation("androidx.media3:media3-cast:$media3Version") // For integrating with Cast
    // For scheduling background operations using Jetpack Work's WorkManager with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-workmanager:$media3Version")

    //todo: LifeCycles
    val lifecycleVersion = "2.8.7"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion") // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion") // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion") // LiveData
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVersion") // Lifecycle utilities for Compose

    //todo: SDP & SSP
    implementation ("com.intuit.ssp:ssp-android:1.1.1")
    implementation("com.intuit.sdp:sdp-android:1.1.1")
    implementation("network.chaintech:sdp-ssp-compose-multiplatform:1.0.4")

    //todo: Retrofit
    val retrofitVersion = "2.11.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")


    //todo: Coroutines Core
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    //todo: Room DB
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    testImplementation("androidx.room:room-testing:$roomVersion") // Test
    implementation("androidx.room:room-paging:$roomVersion") // Paging 3

    //todo:  CameraX core library using the camera2 implementation
    val cameraxVersion = "1.5.0-alpha03"
    // The following line is optional, as the core library is included indirectly by camera-camera2
    implementation("androidx.camera:camera-core:${cameraxVersion}")
    implementation("androidx.camera:camera-camera2:${cameraxVersion}")
    implementation("androidx.camera:camera-lifecycle:${cameraxVersion}") // Lifecycle
    implementation("androidx.camera:camera-video:${cameraxVersion}") // VideoCapture
    implementation("androidx.camera:camera-view:${cameraxVersion}")  // View class
    implementation("androidx.camera:camera-extensions:${cameraxVersion}") //Extension

    //todo: Paging 3
    val pagingVersion = "3.3.2"
    implementation("androidx.paging:paging-runtime-ktx:$pagingVersion")
    implementation("androidx.paging:paging-compose:$pagingVersion")

}

