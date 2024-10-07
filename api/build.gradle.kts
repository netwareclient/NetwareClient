plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.springBoot)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.springBootWeb)
}
