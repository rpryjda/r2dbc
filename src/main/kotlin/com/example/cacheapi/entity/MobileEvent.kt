package com.example.cacheapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("mobile_events")
data class MobileEvent(
        @Id val id: Long?,
        val name: String)