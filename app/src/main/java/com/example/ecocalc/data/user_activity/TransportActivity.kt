package com.example.ecocalc.data.user_activity

import com.example.ecocalc.data.enums.TransportType
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class TransportActivity(
    val id: Int,
    val date: String,
    val type: TransportType,
    val distanceKilometres: Double,
    val carbonInput: Double,
    val electricTransport: Boolean
)
