/*
 * Copyright (c) 2021 Hub Team of panda-lang organization
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.0"
    id("org.jetbrains.kotlin.kapt") version "1.5.0"
    id("org.jmailen.kotlinter") version "3.4.0"
    application
}

group = "org.panda_lang"
version = "2.0.0"

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
}

val kmongo = "4.2.6"
val ktor = "1.5.4"
val tinylog = "2.3.1"
val junit = "5.7.1"
val testcontainers = "1.15.3"

dependencies {
    implementation("com.maxmind.geoip2:geoip2:2.15.0")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("com.michael-bull.kotlin-result:kotlin-result:1.1.11")

    implementation("org.litote.kmongo:kmongo:$kmongo")
    implementation("org.litote.kmongo:kmongo-coroutine:$kmongo")
    implementation("org.litote.kmongo:kmongo-async:$kmongo")
    implementation("org.litote.kmongo:kmongo-reactor:$kmongo")
    implementation("org.litote.kmongo:kmongo-id:$kmongo")
    implementation("org.litote.kmongo:kmongo-id-serialization:$kmongo")
    kapt("org.litote.kmongo:kmongo-annotation-processor:$kmongo")

    implementation("io.ktor:ktor-auth-jwt:$ktor")
    implementation("io.ktor:ktor-auth:$ktor")
    implementation("io.ktor:ktor-locations:$ktor")
    implementation("io.ktor:ktor-client-apache:$ktor")
    implementation("io.ktor:ktor-server-netty:$ktor")
    implementation("io.ktor:ktor-client-gson:$ktor")
    implementation("io.ktor:ktor-gson:$ktor")
    implementation("io.ktor:ktor-serialization:$ktor")
    implementation("io.ktor:ktor-client-serialization:$ktor")
    testImplementation("io.ktor:ktor-server-test-host:$ktor")
    testImplementation("io.ktor:ktor-client-mock:$ktor")

    implementation("org.tinylog:tinylog-api-kotlin:$tinylog")
    implementation("org.tinylog:tinylog-impl:$tinylog")
    implementation("org.tinylog:slf4j-tinylog:$tinylog")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit")
    testImplementation(kotlin("test-junit5"))

    testImplementation("org.testcontainers:testcontainers:$testcontainers")
    testImplementation("org.testcontainers:junit-jupiter:$testcontainers")
    testImplementation("org.testcontainers:mongodb:$testcontainers")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=io.ktor.util.KtorExperimentalAPI"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=io.ktor.locations.KtorExperimentalLocationsAPI"
}

application {
    mainClassName = "org.panda_lang.hub.HubApplicationKt"
}

kotlinter {
    indentSize = 4
    disabledRules = arrayOf("no-blank-line-before-rbrace")
}