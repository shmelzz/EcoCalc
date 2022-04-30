package com.example.ecocalc.data.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM USERS_TABLE WHERE EMAIL = :email")
    fun readUserData(email: String): User

    @Update
    fun updateUsers(user: User)
}