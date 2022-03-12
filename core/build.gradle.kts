plugins {
    application
    id("sw.shadow-conventions")
}

application {
    mainClass.set("net.pistonmaster.serverwrecker.Main")
}

dependencies {
    implementation(projects.serverwreckerCommon)
    implementation(projects.serverwreckerProtocol)
    implementation("commons-cli:commons-cli:1.5.0")
    implementation("com.mojang:brigadier:1.0.500")
    implementation("com.formdev:flatlaf:2.0.2")
    implementation("org.pf4j:pf4j:3.6.0")
    implementation("com.thealtening.api:api:4.1.0")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("net.kyori:adventure-text-serializer-plain:4.10.1")
    implementation("net.kyori:adventure-text-serializer-gson:4.10.1")
}

tasks.named<Jar>("jar").get().manifest {
    attributes["Main-Class"] = "net.pistonmaster.serverwrecker.Main"
}
