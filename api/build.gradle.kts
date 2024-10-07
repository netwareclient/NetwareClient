plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.springBoot)
}

group = "com.github.netwareclient"
version = "1.0.0-dev"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.springBootWeb)
}

// Source directory
sourceSets {
    main {
        kotlin.srcDirs("src/main")
    }
}