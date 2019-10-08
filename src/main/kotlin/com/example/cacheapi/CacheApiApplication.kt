package com.example.cacheapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CacheApiApplication

/*@Bean
fun routes(mobileEventHandler: MobileEventHandler) = router {
    GET("/events/all") { mobileEventHandler.findAll(it) }
}*/



fun main(args: Array<String>) {
    runApplication<CacheApiApplication>(*args)
}
