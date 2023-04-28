package com.example.ecocalc.ui.state_holders.activity_add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecocalc.data.user.UserDao
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.MealActivity
import kotlinx.coroutines.launch

class MealDialogViewModel(private val userRepository: UserDao) : ViewModel() {

    fun addMealActivity(activity: MealActivity) {
        currentUser.mealActivities.add(activity)
        currentUser.mealPrint += activity.carbonInput
        currentUser.carbonPrint += activity.carbonInput
        viewModelScope.launch {
            userRepository.addMealActivity(activity)
            userRepository.updateUsers(currentUser)
        }
    }
}