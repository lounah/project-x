plugins {
    id("com.android.application")
    id("convention.android-common")
    id("convention.kotlin-base")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {

    defaultConfig {
        applicationId = "me.lounah.projectx"
    }

    testBuildType = "debug"

    lint {
        abortOnError = false
        warningsAsErrors = false
        textReport = true
        quiet = true
        checkReleaseBuilds = false
    }
}
