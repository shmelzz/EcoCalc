package com.example.ecocalc.ui.state_holders.activity_add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecocalc.data.user.UserDao
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.TransportActivity
import kotlinx.coroutines.launch

class TransportDialogViewModel(private val userRepository: UserDao) : ViewModel() {

    fun addTransportActivity(activity: TransportActivity, inputPerKm: Double) {
        currentUser.transportActivities.add(activity)
        currentUser.transportPrint += inputPerKm * activity.distanceKilometres
        currentUser.carbonPrint += inputPerKm * activity.distanceKilometres
        viewModelScope.launch {
            userRepository.addTransportActivity(activity)
            userRepository.updateUsers(currentUser)
        }
    }
}