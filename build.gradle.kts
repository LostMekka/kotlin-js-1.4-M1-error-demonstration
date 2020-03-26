plugins {
    id("org.jetbrains.kotlin.js") version "1.4-M1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

kotlin {
    target {
        browser { }
        produceExecutable()
        val main by compilations.getting {
            kotlinOptions {
                moduleKind = "commonjs"
                freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
            }
        }
    }
}
