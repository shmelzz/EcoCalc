package com.example.ecocalc.data.user_activity

import com.example.ecocalc.data.enums.PlasticType
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class PlasticActivity(
    val id: Int,
    val date: String,
    val type: PlasticType,
    val carbonInput: Double
)
