import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.21"
    application
}

group = "org.panda_lang"
version = "1.0.0"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
}

dependencies {
    implementation("org.litote.kmongo:kmongo:4.2.4")
    implementation("org.litote.kmongo:kmongo-coroutine:4.2.4")
    implementation("org.litote.kmongo:kmongo-async:4.2.4")
    implementation("org.litote.kmongo:kmongo-reactor:4.2.4")

    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("io.ktor:ktor-auth-jwt:1.4.0")
    implementation("io.ktor:ktor-auth:1.4.0")
    implementation("io.ktor:ktor-locations:1.4.0")
    implementation("io.ktor:ktor-client-apache:1.4.0")
    implementation("io.ktor:ktor-server-netty:1.4.0")
    implementation("io.ktor:ktor-html-builder:1.4.0")
    implementation("io.ktor:ktor-client-gson:1.4.0")
    implementation("io.ktor:ktor-gson:1.4.0")
    implementation("io.ktor:ktor-serialization:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")

    implementation("org.tinylog:tinylog-api-kotlin:2.2.1")
    implementation("org.tinylog:tinylog-impl:2.2.1")
    implementation("org.tinylog:slf4j-tinylog:2.2.1")

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs += "-Xmx1G"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=io.ktor.util.KtorExperimentalAPI"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=io.ktor.locations.KtorExperimentalLocationsAPI"
}

application {
    mainClassName = "org.panda_lang.hub.HubApplicationKt"
}