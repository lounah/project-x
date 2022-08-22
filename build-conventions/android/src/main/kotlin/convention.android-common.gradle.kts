import com.android.build.gradle.BaseExtension
import me.lounah.projectx.environment.Environment
import me.lounah.projectx.util.withVersionCatalog

plugins {
    id("convention.build-types")
}

configure<BaseExtension> {

    project.withVersionCatalog { libs ->
        buildToolsVersion(libs.versions.buildTools.get())
        compileSdkVersion(libs.versions.compileSdk.get().toInt())

        defaultConfig {
            minSdk = libs.versions.minSdk.get().toInt()
            targetSdk = libs.versions.targetSdk.get().toInt()
            versionName = Environment.default.versionName
            versionCode = Environment.default.versionCode

            vectorDrawables {
                useSupportLibrary = true
            }

            javaCompileOptions {
                annotationProcessorOptions {
                    arguments(mutableMapOf("room.incremental" to "true"))
                }
            }
        }
    }

    sourceSets {
        named("main").configure { java.srcDir("src/main/kotlin") }
        named("androidTest").configure { java.srcDir("src/androidTest/kotlin") }
        named("test").configure { java.srcDir("src/test/kotlin") }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    @Suppress("UnstableApiUsage")
    with(buildFeatures) {
        viewBinding = true
        buildConfig = true
        compose = false
    }
}
