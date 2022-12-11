plugins {
  kotlin("multiplatform") version(libs.versions.kotlin.get()) apply(false)
  id("org.jetbrains.compose") version(libs.versions.compose.get()) apply(false)
}

allprojects {
  group = "com.ghackett.launchpad.gui"
  version = "1.0-SNAPSHOT"
}

tasks.wrapper {
  gradleVersion = libs.versions.gradle.get()
  distributionType = Wrapper.DistributionType.ALL
}
