package com.thevarungupta.spring.boot.kotlin.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/hello")
@RestController
class HomeController {

    @GetMapping
    fun index(): String{
        return "Hello World"
    }

    @GetMapping("/{name}")
    fun sayHello(@PathVariable("name") name: String): String{
        return  "Hello $name"
    }

    @GetMapping("/{firstName}/{lastName}")
    fun sayHello(@PathVariable("firstName") firstName: String,
    @PathVariable("lastName") lastName: String): String{
        return "Hello $firstName $lastName"
    }
}