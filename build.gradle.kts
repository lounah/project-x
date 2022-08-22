buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.androidGradle)
        classpath(libs.kotlinGradle)
    }

    allprojects {
        repositories {
            google()
            mavenCentral()
            jcenter()
        }
    }
}

