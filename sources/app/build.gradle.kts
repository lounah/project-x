plugins {
    id("convention.android-application")
}

dependencies {
    implementation(projects.sources.feature.featureFeed)
    implementation(libs.material)
    implementation(libs.appcompat)
    implementation(libs.coreKtx)
    implementation(libs.vbdelegate)
    implementation(libs.bundles.elmslie)
}
