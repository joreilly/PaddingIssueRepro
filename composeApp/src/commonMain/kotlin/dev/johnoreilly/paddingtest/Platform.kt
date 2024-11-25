package dev.johnoreilly.paddingtest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform