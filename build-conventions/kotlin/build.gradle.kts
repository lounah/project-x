plugins {
    `kotlin-dsl`
}

group = "me.lounah.build-conventions"

dependencies {
    implementation(projects.environment)
    implementation(projects.testing)
    implementation(libs.kotlinGradle)
}
