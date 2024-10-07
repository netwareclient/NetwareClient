package com.github.netwareclient.model.helloWorld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping
    fun helloWorld(): Message {
        return Message(
            message = "Hello World",
            status = 200
        )
    }
}