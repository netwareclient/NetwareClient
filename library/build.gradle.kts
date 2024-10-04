plugins {
    alias(libs.plugins.kotlin)
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

}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

// Custom source code directory
sourceSets {
    main {
        kotlin.srcDirs("src/main")
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