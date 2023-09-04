package com.thevarungupta.spring.boot.kotlin.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinAppApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinAppApplication>(*args)
}
