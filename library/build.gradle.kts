plugins {
    alias(libs.plugins.kotlin)g
}

repositories {
    mavenCentral()
}

// Custom source code directory
sourceSets {
    main {
        kotlin.srcDirs("src/main")
    }
}

dependencies {

}