package com.example.ecocalc.data.user

import androidx.room.TypeConverter
import com.example.ecocalc.data.enums.GoalProgress
import com.example.ecocalc.data.enums.MealType
import com.example.ecocalc.data.enums.PlasticType
import com.example.ecocalc.data.enums.TransportType
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.data.user_activity.TransportActivity
import com.example.ecocalc.data.utils.Goal
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun fromMealType(type: MealType): String {
        return type.name
    }

    @TypeConverter
    fun toMealType(type: String): MealType {
        return MealType.valueOf(type)
    }

    @TypeConverter
    fun fromTransportType(type: TransportType): String {
        return type.name
    }

    @TypeConverter
    fun toTransportType(type: String): TransportType {
        return TransportType.valueOf(type)
    }

    @TypeConverter
    fun fromPlasticType(type: PlasticType): String {
        return type.name
    }

    @TypeConverter
    fun toPlasticType(type: String): PlasticType {
        return PlasticType.valueOf(type)
    }

    @TypeConverter
    fun fromGoalProgressType(type: GoalProgress): String {
        return type.name
    }

    @TypeConverter
    fun toGoalProgressType(type: String): GoalProgress {
        return GoalProgress.valueOf(type)
    }
}