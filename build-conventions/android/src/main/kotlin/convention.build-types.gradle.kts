import com.android.build.gradle.BaseExtension
import com.android.builder.internal.ClassFieldImpl
import me.lounah.projectx.environment.Environment
import org.gradle.kotlin.dsl.configure
import java.util.*

configure<BaseExtension> {

    signingConfigs {
        getByName("debug") {
            val env = Environment.debug
            storeFile = File("${project.rootDir}/signing/debug.keystore")
            storePassword = env.signing.storePassword
            keyAlias = env.signing.keyAlias
            keyPassword = env.signing.keyPassword
        }
        create("release") {
            val env = Environment.production
            storeFile = File("${project.rootDir}/signing/debug.keystore")
            storePassword = env.signing.storePassword
            keyAlias = env.signing.keyAlias
            keyPassword = env.signing.keyPassword
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            matchingFallbacks += listOf("release")
        }
    }
}
