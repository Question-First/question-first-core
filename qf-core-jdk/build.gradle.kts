/*
 * Copyright (c) 2024 Question First
 *
 * This source code is licensed under the MIT License found in the LICENSE file in the root directory of this source tree.
 *
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.kotlin.jvm)

    // Apply the java-library plugin for API and implementation separation.
    id("java-library")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.jackson.module.kotlin)

    testImplementation(libs.json.unit.assertj)
}

java {
    val version = JavaVersion.toVersion(libs.versions.qf.libs.java.get())
    sourceCompatibility = version
    targetCompatibility = version
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.qf.libs.java.get().toInt()))
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
