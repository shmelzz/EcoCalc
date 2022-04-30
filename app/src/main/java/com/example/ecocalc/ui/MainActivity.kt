package com.example.ecocalc.ui

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ecocalc.R
import com.example.ecocalc.data.user.User
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_account, R.id.navigation_goals, R.id.navigation_articles
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        currentUser = User()

        currentUser.email = intent.extras?.getString("username").toString()
        Toast.makeText(
            baseContext, currentUser.email,
            Toast.LENGTH_SHORT
        ).show()


        if (intent.extras?.getBoolean("isNewUser") == true) {
            val userDao = UserDatabase.getDataBase(application).userDao()
            userDao.addUser(currentUser)
        } else {
            val userDao = UserDatabase.getDataBase(application).userDao()
            currentUser = userDao.readUserData(intent.extras?.getString("username").toString())
        }
    }
}