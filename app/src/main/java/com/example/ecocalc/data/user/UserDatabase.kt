package com.example.ecocalc.data.user

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.data.user_activity.TransportActivity
import com.example.ecocalc.data.utils.Goal

@TypeConverters(Converters::class)
@Database(
    entities =
    [User::class, MealActivity::class, TransportActivity::class, PlasticActivity::class, Goal::class],
    version = 1, exportSchema = false
)
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
            ).build()

            INSTANCE = instance
            return instance
        }
    }
}