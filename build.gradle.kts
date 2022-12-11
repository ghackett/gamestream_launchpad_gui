plugins {
  alias(libs.plugins.kmp) apply(false)
  alias(libs.plugins.compose) apply(false)
}

allprojects {
  group = "com.ghackett.launchpad.gui"
  version = "1.0-SNAPSHOT"
}

tasks.wrapper {
  gradleVersion = libs.versions.gradle.get()
  distributionType = Wrapper.DistributionType.ALL
}
