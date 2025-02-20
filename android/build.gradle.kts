plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

group = "com.airfore.cell_info"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

android {
    namespace = "com.airfore.cell_info"

    compileSdk = 35

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
    defaultConfig {
        minSdk = 16
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("com.google.code.gson:gson:2.8.7")
    implementation("androidx.core:core:1.9.0")
}