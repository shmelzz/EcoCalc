package com.example.ecocalc.data.user_activity

import com.example.ecocalc.data.enums.MealType
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class MealActivity(
    val id: Int,
    val date: String,
    val type: MealType,
    val carbonInput: Double
)