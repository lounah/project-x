rootProject.name = "project-x"

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }

    pluginManagement {
        repositories {
            google()
            mavenCentral()
        }
    }
}

includeBuild("build-settings")
includeBuild("build-conventions")

include(":app")
