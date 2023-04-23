package com.example.ecocalc.data.user

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.data.user_activity.TransportActivity
import com.example.ecocalc.data.utils.Goal

var currentUser: User = User()

@Entity(tableName = "users_table")
class User {
    @PrimaryKey
    var email: String = " "
    var photo: Int = 2

    var carbonPrint: Double = 0.1
    var transportPrint: Double = 0.1
    var mealPrint: Double = 0.1
    var plasticPrint: Double = 0.1

    @Ignore var transportActivities: ArrayList<TransportActivity> = arrayListOf()
    @Ignore var mealActivities: ArrayList<MealActivity> = arrayListOf()
    @Ignore var plasticActivities: ArrayList<PlasticActivity> = arrayListOf()

    @Ignore var goalsToExplore: ArrayList<Goal> = arrayListOf()
    @Ignore var achievedGoals: ArrayList<Goal> = arrayListOf()
    @Ignore var inProgressGoals: ArrayList<Goal> = arrayListOf()
}