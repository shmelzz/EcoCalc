package com.example.ecocalc.data.user

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(Converters::class)
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserDatabase? = null

        fun getDataBase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "users_database"
            ).allowMainThreadQueries().build()

            // TODO УБРАТЬ allowMainThreadQueries - ТАК ПИСАТЬ НЕ НАДО

            INSTANCE = instance
            return instance
        }
    }
}