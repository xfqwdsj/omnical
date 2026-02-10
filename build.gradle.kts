plugins {
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.dokka)
    alias(libs.plugins.mavenPublish) apply false
}

dependencies {
    dokka(project(":omnical-icalendar"))
//    dokka(project(":omnical-formatter-icalendar"))
    dokka(project(":omnical-biweekly"))
}
