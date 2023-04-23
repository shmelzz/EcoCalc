package com.example.ecocalc.data.user_activity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecocalc.data.enums.PlasticType
import kotlinx.serialization.Serializable
import java.util.*

@Entity(tableName = "plastic_table")
data class PlasticActivity(
    @PrimaryKey
    val id: UUID,
    val userId: String,
    val date: String,
    val type: PlasticType,
    val carbonInput: Double
)

