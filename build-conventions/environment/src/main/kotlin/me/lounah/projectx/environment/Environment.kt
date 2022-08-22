package me.lounah.projectx.environment

import org.gradle.api.Project

interface Environment {

    val versionCode: Int
        get() = System.getenv().getOrDefault("versionCode", "1").toInt()

    val versionName: String
        get() = System.getenv().getOrDefault("versionName", "0.0.1").orEmpty()

    val signing: Signing

    object Gradle {

        fun isCi(project: Project) = project.hasProperty("ci")
    }

    private class Debug : Environment {
        override val signing: Signing = Signing.debug
    }

    private class Production : Environment {
        override val signing: Signing = Signing.release
    }

    companion object {
        val debug: Environment = Debug()
        val production: Environment = Production()
        val default: Environment = Debug()
    }
}
