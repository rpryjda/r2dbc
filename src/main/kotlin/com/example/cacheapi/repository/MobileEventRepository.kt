package com.example.cacheapi.repository

import com.example.cacheapi.entity.MobileEvent
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface MobileEventRepository : ReactiveCrudRepository<MobileEvent, Long>