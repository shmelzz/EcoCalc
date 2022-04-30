package com.example.ecocalc.data.user

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    lateinit var readUserData: User

    fun readUser(email: String) {
        readUserData = userDao.readUserData(email)
    }

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}