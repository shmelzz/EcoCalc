package com.example.ecocalc.data.user

import androidx.room.TypeConverter
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.data.user_activity.TransportActivity
import com.example.ecocalc.data.utils.Goal
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun fromListGoal(value: ArrayList<Goal>) = Json.encodeToString(value)

    @TypeConverter
    fun toListGoal(value: String) = Json.decodeFromString<ArrayList<Goal>>(value)

    @TypeConverter
    fun fromListTransport(value: ArrayList<TransportActivity>) = Json.encodeToString(value)

    @TypeConverter
    fun toListTransport(value: String) = Json.decodeFromString<ArrayList<TransportActivity>>(value)

    @TypeConverter
    fun fromListMeal(value: ArrayList<MealActivity>) = Json.encodeToString(value)

    @TypeConverter
    fun toListMeal(value: String) = Json.decodeFromString<ArrayList<MealActivity>>(value)

    @TypeConverter
    fun fromListPlastic(value: ArrayList<PlasticActivity>) = Json.encodeToString(value)

    @TypeConverter
    fun toListPlastic(value: String) = Json.decodeFromString<ArrayList<PlasticActivity>>(value)
}