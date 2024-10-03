plugins {
    alias(libs.plugins.kotlin)
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