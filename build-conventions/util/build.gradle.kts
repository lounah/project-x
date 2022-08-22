plugins {
    `kotlin-dsl`
}

group = "me.lounah.build-conventions"

dependencies {
    implementation(libs.commonsConfiguration)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}