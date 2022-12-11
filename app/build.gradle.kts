import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  alias(libs.plugins.kmp)
  alias(libs.plugins.compose)
}


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
