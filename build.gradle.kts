plugins {
    id("java")
}

group = "org.cointracker.transaction"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.opencsv:opencsv:5.9")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.cointracker.transaction.Main"
    }
}

tasks.test {
    useJUnitPlatform()
}