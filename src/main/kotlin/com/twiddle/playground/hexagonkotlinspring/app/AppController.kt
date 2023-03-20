package com.twiddle.playground.hexagonkotlinspring.app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController {

    @GetMapping("/")
    fun test(): String {
        return "muhehe"
    }
}
