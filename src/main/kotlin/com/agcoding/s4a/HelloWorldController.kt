package com.agcoding.s4a

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloWorldController {
    @GetMapping
    fun hello() : String = "Hello World"
}