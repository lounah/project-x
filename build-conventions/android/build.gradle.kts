plugins {
    `kotlin-dsl`
}

group = "me.lounah.build-conventions"

dependencies {
    implementation(projects.kotlin)
    implementation(projects.environment)
    implementation(projects.util)
    implementation(libs.kotlinGradle)
    implementation(libs.androidGradle)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
