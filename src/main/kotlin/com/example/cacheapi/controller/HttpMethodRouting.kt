package com.example.cacheapi.controller

import com.example.cacheapi.handler.MobileEventHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class HttpMethodRouting {

    @Bean
    fun routes(mobileEventHandler: MobileEventHandler) = router {
        GET("/events/show") { mobileEventHandler.findAll(it) }
    }
}