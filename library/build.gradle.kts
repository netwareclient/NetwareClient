plugins {
    alias(libs.plugins.mavenPublish)
}

private val libraryArtifactId = "netwareclient"
private val libraryReleaseVersion = "0.0.1-alpha"
private val libraryGroup = "com.github.netwareclient"

group = libraryGroup
version = libraryReleaseVersion

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.jupiterApi)
    testImplementation(libs.jupiterEngine)
}

tasks.test {
    useJUnitPlatform()
}

// Custom source code directory
sourceSets {
    main {
        kotlin.srcDirs("src/main")
    }
    test {
        kotlin.srcDirs("src/test")
    }
}

// Local publishing configuration
publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
            groupId = libraryGroup
            artifactId = libraryArtifactId
            version = libraryReleaseVersion
        }

        repositories {
            mavenLocal()
        }
    }
}