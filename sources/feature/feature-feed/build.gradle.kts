plugins {
    id("convention.android-library")
}

dependencies {
    implementation(libs.material)
    implementation(libs.appcompat)
    implementation(libs.coreKtx)
    implementation(libs.vbdelegate)
    implementation(libs.swipeRefresh)
    implementation(libs.tiRecycler)
    implementation(libs.tiRecyclerRx)
    implementation(libs.bundles.elmslie)
}