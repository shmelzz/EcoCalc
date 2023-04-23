package com.example.ecocalc.data.user_activity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecocalc.data.enums.MealType
import kotlinx.serialization.Serializable
import java.util.*

@Entity(tableName = "meal_table")
data class MealActivity(
    @PrimaryKey
    val id: UUID,
    val userId: String,
    val date: String,
    val type: MealType,
    val carbonInput: Double
)