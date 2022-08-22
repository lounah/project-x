import me.lounah.projectx.util.withVersionCatalog
import org.jetbrains.kotlin.gradle.plugin.KotlinBasePluginWrapper

project.withVersionCatalog { libs ->
    plugins.withType<KotlinBasePluginWrapper> {
        dependencies {
            add("testImplementation", libs.junitJupiterApi)
            add("testImplementation", libs.truth)

            add("testRuntimeOnly", libs.junitJupiterEngine)
            add("testRuntimeOnly", libs.junitPlatformRunner)
            add("testRuntimeOnly", libs.junitPlatformLauncher)
        }
    }
}
