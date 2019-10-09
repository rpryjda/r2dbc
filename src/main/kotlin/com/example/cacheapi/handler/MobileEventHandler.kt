package com.example.cacheapi.handler

import com.example.cacheapi.entity.MobileEvent
import com.example.cacheapi.repository.MobileEventRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux

@Component
class MobileEventHandler(private val mobileEventRepository: MobileEventRepository) {
    fun findAll(request: ServerRequest) = ok().body(mobileEventRepository.findAll())
}