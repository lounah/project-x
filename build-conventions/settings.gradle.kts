rootProject.name = "build-conventions"

enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    includeBuild("../build-settings")
}

plugins {
    id("convention-dependencies")
}

include("android")
include("kotlin")
include("testing")
include("environment")
include("util")