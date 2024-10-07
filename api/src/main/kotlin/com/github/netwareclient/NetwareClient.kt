package com.github.netwareclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NetwareClient

fun main(args: Array<String>) {
    runApplication<NetwareClient>(*args)
}