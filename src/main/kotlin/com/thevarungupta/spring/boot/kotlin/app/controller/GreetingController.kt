package com.thevarungupta.spring.boot.kotlin.app.controller

import com.thevarungupta.spring.boot.kotlin.app.service.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/greetings")
@RestController
class GreetingController(val greetingService: GreetingService) {

    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable("name") name: String): String{
        return greetingService.retrieveGreeting(name)
    }
}