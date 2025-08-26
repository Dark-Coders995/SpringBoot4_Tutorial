package com.agcoding.s4a

import com.agcoding.s4a.config.QuoteConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
	QuoteConfig::class
)
class S4aApplication

fun main(args: Array<String>) {
	runApplication<S4aApplication>(*args)
}
