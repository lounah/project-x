import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("convention.unit-testing")
}

val kotlinLanguageVersion = "1.6"

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()

        allWarningsAsErrors = true

        languageVersion = kotlinLanguageVersion
        apiVersion = kotlinLanguageVersion

        freeCompilerArgs = freeCompilerArgs +
                "-opt-in=kotlin.RequiresOptIn" +
                "-progressive"
    }
}
