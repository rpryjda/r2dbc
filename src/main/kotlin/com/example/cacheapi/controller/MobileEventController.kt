package com.example.cacheapi.controller

import com.example.cacheapi.entity.MobileEvent
import com.example.cacheapi.repository.MobileEventRepository
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MobileEventController(private val databaseClient: DatabaseClient,
                            private val mobileEvenRepository: MobileEventRepository) {

    @GetMapping("/events")
    fun getMobileEvents() = databaseClient
            .execute("SELECT * FROM mobile_events")
//            .as(MobileEvent::javaClass)
            .fetch()
            .all()

    @PostMapping("/events")
    fun createTableMobileEvents() = databaseClient
            .execute("CREATE TABLE mobile_events(id SERIAL PRIMARY KEY, name VARCHAR(100))")
            .fetch()
            .all()

    @PostMapping("/events/save")
    fun saveMobileEvent() = databaseClient
            .execute("INSERT INTO mobile_events(name) VALUES('Rafal')")
            .fetch()
            .all()

    @GetMapping("/events/show")
    fun getMobileEventsViaRepository() = mobileEvenRepository.findAll()

    @PostMapping("/events/show")
    fun saveMobileEventViaRepository(@RequestBody event: MobileEvent) = mobileEvenRepository.save(event)
}