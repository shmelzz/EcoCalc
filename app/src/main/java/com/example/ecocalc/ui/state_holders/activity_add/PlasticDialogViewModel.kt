package com.example.ecocalc.ui.state_holders.activity_add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecocalc.data.user.UserDao
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.PlasticActivity
import kotlinx.coroutines.launch

class PlasticDialogViewModel(private val userRepository: UserDao) : ViewModel() {

    fun addPlasticActivity(activity: PlasticActivity) {
        currentUser.plasticActivities.add(activity)
        currentUser.plasticPrint += activity.carbonInput
        currentUser.carbonPrint += activity.carbonInput
        viewModelScope.launch {
            userRepository.addPlasticActivity(activity)
            userRepository.updateUsers(currentUser)
        }
    }
}