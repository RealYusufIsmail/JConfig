import java.net.URL
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript { dependencies { classpath("org.jetbrains.dokka:dokka-base:1.9.20") } }

plugins {
    kotlin("jvm") version "1.9.10"
    id("com.diffplug.spotless") version "6.22.0"
    id("org.jetbrains.dokka") version "1.9.10"
    application
    `maven-publish`
    signing
    jacoco // code coverage reports
}

extra.apply {
    set("name", "JConfig")
    set("description", "Json Configurations used to store tokens and other sensitive data")
    set("group", "io.github.realyusufismail")
    set("version", "1.1.1")
    set("dev_id", "yusuf")
    set("dev_name", "Yusuf Ismail")
    set("dev_email", "yusufgamer222@gmail.com")
    set("dev_organization", "RealYusufIsmail")
    set("dev_organization_url", "https://github.com/RealYusufIsmail")
    set("gpl_name", "Apache-2.0 license")
    set("gpl_url", "https://github.com/RealYusufIsmail/jconfig/blob/master/LICENSE")
    // Make sure we have a default for initial configuration evaluation
    set("isReleaseVersion", "false")
}

group = "io.github.realyusufismail"

val releaseVersion by extra(!version.toString().endsWith("-SNAPSHOT"))

apply(from = "gradle/tasks/incrementVersion.gradle.kts")

repositories { mavenCentral() }

dependencies {
    // json
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

tasks.jacocoTestReport {
    group = "Reporting"
    description = "Generate Jacoco coverage reports after running tests."
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    finalizedBy("jacocoTestCoverageVerification")
}

configurations { all { exclude(group = "org.slf4j", module = "slf4j-log4j12") } }

spotless {
    kotlin {
        // Excludes build folder since it contains generated java classes.
        targetExclude("build/**")
        ktfmt("0.39").dropboxStyle()

        licenseHeader(
            """/*
 * Copyright 2022 Yusuf Arfan Ismail (RealYusufIsmail)
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ """)
    }

    kotlinGradle {
        target("**/*.gradle.kts")
        ktfmt("0.39").dropboxStyle()
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "11" }

application { mainClass.set("MainKt") }

java {
    withJavadocJar()
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

afterEvaluate {
    val version = extra["version"] as String
    extra["isReleaseVersion"] = !version.endsWith("RELEASE")
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

publishing {
    publications {
        create<MavenPublication>("Jconfig") {
            from(components["java"])
            // artifactId = project.artifactId // or maybe archiveBaseName?
            pom {
                name.set(extra["name"] as String)
                description.set(extra["description"] as String)
                url.set("https://github.com/RealYusufIsmail/jconfig")
                licenses {
                    license {
                        name.set(extra["gpl_name"] as String)
                        url.set(extra["gpl_url"] as String)
                    }
                }
                developers {
                    developer {
                        id.set(extra["dev_id"] as String)
                        name.set(extra["dev_name"] as String)
                        email.set(extra["dev_email"] as String)
                        organization.set(extra["dev_organization"] as String)
                        organizationUrl.set(extra["dev_organization_url"] as String)
                    }
                }
                scm {
                    connection.set("https://github.com/RealYusufIsmail/jconfig.git")
                    developerConnection.set(
                        "scm:git:ssh://git@github.com/RealYusufIsmail/jconfig.git")
                    url.set("github.com/RealYusufIsmail/jconfig")
                }
            }
        }
    }
    repositories {
        maven {
            name = "MavenCentral"
            val releaseRepo = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotRepo = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = uri((if (releaseVersion) releaseRepo else snapshotRepo))
            credentials {
                // try to get it from system gradle.properties
                logger.debug("Trying to get credentials from system gradle.properties")
                username =
                    when {
                        systemHasEnvVar("MAVEN_USERNAME") -> {
                            logger.debug("Found username in system gradle.properties")
                            System.getenv("MAVEN_USERNAME")
                        }
                        project.hasProperty("MAVEN_USERNAME") -> {
                            logger.debug("MAVEN_USERNAME found in gradle.properties")
                            project.property("MAVEN_USERNAME") as String
                        }
                        else -> {
                            logger.debug(
                                "MAVEN_USERNAME not found in system properties, meaning if you are trying to publish to maven central, it will fail")
                            null
                        }
                    }

                password =
                    when {
                        systemHasEnvVar("MAVEN_PASSWORD") -> {
                            logger.debug("Found password in system gradle.properties")
                            System.getenv("MAVEN_PASSWORD")
                        }
                        project.hasProperty("MAVEN_PASSWORD") -> {
                            logger.debug("MAVEN_PASSWORD found in gradle.properties")
                            project.property("MAVEN_PASSWORD") as String
                        }
                        else -> {
                            logger.debug(
                                "MAVEN_PASSWORD not found in system properties, meaning if you are trying to publish to maven central, it will fail")
                            null
                        }
                    }
            }
        }
    }
}

fun systemHasEnvVar(varName: String): Boolean {
    return System.getenv(varName) != null
}

signing {
    afterEvaluate {
        // println "sign: " + isReleaseVersion
        val isRequired =
            releaseVersion &&
                (tasks.withType<PublishToMavenRepository>().find { gradle.taskGraph.hasTask(it) } !=
                    null)
        setRequired(isRequired)
        sign(publishing.publications["Jconfig"])
    }
}

tasks.getByName("dokkaHtml", DokkaTask::class) {
    dokkaSourceSets.configureEach {
        includes.from("Package.md")
        jdkVersion.set(11)
        sourceLink {
            localDirectory.set(file("src/main/kotlin"))
            remoteUrl.set(
                URL("https://github.com/RealYusufIsmail/jconfig/tree/master/src/main/kotlin"))
            remoteLineSuffix.set("#L")
        }

        pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
            footerMessage = "Copyright © 2022 Yusuf Arfan Ismail(RealYusufIsmail)"
        }
    }
}
