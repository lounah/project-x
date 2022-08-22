import me.lounah.projectx.util.withVersionCatalog
import org.jetbrains.kotlin.gradle.plugin.KotlinBasePluginWrapper

project.withVersionCatalog { _ ->
    plugins.withType<KotlinBasePluginWrapper> {
        dependencies {
            // TODO: add android test dependencies.
        }
    }
}
