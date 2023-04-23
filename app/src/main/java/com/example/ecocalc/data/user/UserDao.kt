package com.example.ecocalc.data.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.data.user_activity.TransportActivity

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM USERS_TABLE WHERE EMAIL = :email")
    fun readUserData(email: String): User

    @Update
    suspend fun updateUsers(user: User)

    @Query("SELECT * FROM meal_table WHERE userId = :email")
    fun readMealActivitiesForUser(email: String): List<MealActivity>

    @Query("SELECT * FROM transport_table WHERE userId = :email")
    fun readTransportActivitiesForUser(email: String): List<TransportActivity>

    @Query("SELECT * FROM plastic_table WHERE userId = :email")
    fun readPlasticActivitiesForUser(email: String): List<PlasticActivity>

    @Insert
    suspend fun addPlasticActivity(PlasticActivity: PlasticActivity)

    @Insert
    suspend fun addTransportActivity(transportActivity: TransportActivity)

    @Insert
    suspend fun addMealActivity(mealActivity: MealActivity)
}