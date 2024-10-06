plugins {
    alias(libs.plugins.kotlin)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
}

sourceSets {
    main {
        kotlin.srcDirs("/kotlin")
        java.srcDirs("/java")
    }
}