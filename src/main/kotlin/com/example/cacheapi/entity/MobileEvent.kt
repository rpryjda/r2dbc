package com.example.cacheapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("mobile_events")
data class MobileEvent(
//        @Id val id: Long?,
        val userId: Long,
        val createDate: Long,
        val payload: String)