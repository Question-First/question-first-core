/*
 * Copyright (c) 2024 Question First
 *
 * This source code is licensed under the MIT License found in the LICENSE file in the root directory of this source tree.
 *
 */

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "question-first-core"
include("qf-core-jdk","qf-core-junit5")
