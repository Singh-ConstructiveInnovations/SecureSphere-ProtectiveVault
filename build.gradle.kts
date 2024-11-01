// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    val kotlinVersion = "2.0.21"
    id("com.android.application") version "8.7.2" apply false
    id("org.jetbrains.kotlin.android") version kotlinVersion apply false

    id("org.jetbrains.kotlin.plugin.compose") version kotlinVersion apply false
    id("androidx.navigation.safeargs.kotlin") version "2.8.3" apply false
    id("com.google.dagger.hilt.android") version "2.52" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.26" apply false

}