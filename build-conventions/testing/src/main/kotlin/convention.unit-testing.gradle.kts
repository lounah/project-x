import me.lounah.projectx.util.withVersionCatalog
import org.jetbrains.kotlin.gradle.plugin.KotlinBasePluginWrapper

project.withVersionCatalog { libs ->
    plugins.withType<KotlinBasePluginWrapper> {
        dependencies {

        }
    }
}
