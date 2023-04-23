package com.example.ecocalc.data.user_activity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.ecocalc.data.enums.TransportType
import kotlinx.serialization.Serializable
import java.util.*

@Entity(tableName = "transport_table")
data class TransportActivity(
    @PrimaryKey
    val id: UUID,
    val userId: String,
    val date: String,
    val type: TransportType,
    val distanceKilometres: Double,
    val carbonInput: Double,
    val electricTransport: Boolean
)
