@file:OptIn(ExperimentalComposeLibrary::class)

import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  kotlin("multiplatform") version(libs.versions.kotlin.get())
  id("org.jetbrains.compose") version(libs.versions.compose.get())
}

group = "com.ghackett.launchpad.gui"
version = "1.0-SNAPSHOT"

kotlin {
  jvm {
    compilations.all {
      kotlinOptions.jvmTarget = "11"
    }
    withJava()
  }
  sourceSets {
    val jvmMain by getting {
      dependencies {
        implementation(compose.desktop.currentOs)
        implementation(compose.material3)
      }
    }
    val jvmTest by getting
    all { languageSettings.optIn("kotlin.RequiresOptIn") }
  }
}

compose.desktop {
  application {
    mainClass = "MainKt"
    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = "gamestream_launchpad_gui"
      packageVersion = "1.0.0"
    }
  }
}
