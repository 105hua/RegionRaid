/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.diffplug.spotless") version "6.23.3"
}

group = "com.luffbox"
version = "1.1.0"

repositories {
    mavenCentral()
    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
    maven {
        url = uri("https://maven.enginehub.org/repo/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("com.sk89q.worldguard:worldguard-bukkit:7.0.9")
}

val targetJavaVersion = 17

java {
    val javaVersion = JavaVersion.toVersion(targetJavaVersion)
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    if (JavaVersion.current() < javaVersion) {
        toolchain.languageVersion.set(JavaLanguageVersion.of(targetJavaVersion))
    }
}

tasks.withType(JavaCompile::class).configureEach {
    if(targetJavaVersion >= 10 || JavaVersion.current().isJava10Compatible){
        options.release.set(targetJavaVersion)
    }
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml"){
        expand(props)
    }
}

tasks.shadowJar{
    isEnableRelocation = true
    relocationPrefix = "${rootProject.property("group")}.${rootProject.property("name").toString().lowercase()}.lib"
    minimize()
    archiveClassifier.set("")
}

tasks.build{
    dependsOn("shadowJar")
}

spotless {
    format("misc") {
        target(listOf("**/*.gradle", "**/*.md"))
        trimTrailingWhitespace()
        indentWithSpaces(4)
    }
    kotlin {
        ktlint("1.1.0").editorConfigOverride(
            mapOf(
                "max_line_length" to 500
            )
        )
    }
}