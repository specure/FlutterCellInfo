import kotlin.io.path.exists
import kotlin.io.use
import kotlin.text.toInt
import java.util.Properties
import java.nio.charset.Charset

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") // Corrected plugin ID
    id("dev.flutter.flutter-gradle-plugin")
}

val localProperties = Properties()
val localPropertiesFile = file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.reader(Charset.forName("UTF-8")).use { reader ->
        localProperties.load(reader)
    }
}

val flutterVersionCode: String = localProperties.getProperty("flutter.versionCode") ?: "1"
val flutterVersionName: String = localProperties.getProperty("flutter.versionName") ?: "1.0"

android {
    namespace = "com.airfore.cell_info_example"
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
        applicationId = "com.airfore.cell_info_example"
        minSdk = flutter.minSdkVersion //21 // Use a default value if flutter.minSdkVersion is not available
        targetSdk = 35
        versionCode = flutterVersionCode.toInt()
        versionName = flutterVersionName
    }

    buildTypes {
        release {
            // Signing with the debug keys for now, so `flutter run --release` works.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
}