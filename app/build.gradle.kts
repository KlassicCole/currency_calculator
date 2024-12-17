plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.currency_counter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.currency_counter"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }

    kotlinOptions {
        jvmTarget = "1.8"
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
}

dependencies {

    // Application dependencies
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.4")
    implementation("androidx.compose.material:material:1.5.4")
    implementation("androidx.compose.runtime:runtime:1.5.4")
    implementation("androidx.compose.material3:material3:1.1.2")

    // Testing dependencies
    testImplementation("junit:junit:4.13.2") // JUnit for unit tests
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // AndroidX JUnit
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Espresso for UI tests
    androidTestImplementation("androidx.test:runner:1.5.2") // Test runner
    androidTestImplementation("androidx.test:rules:1.5.0") // Test rules
}
