package com.example.ecocalc.ui.state_holders.dialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecocalc.data.user.UserDao
import com.example.ecocalc.data.user.currentUser
import kotlinx.coroutines.launch

class AvatarDialogViewModel(private val userRepository: UserDao): ViewModel() {

    fun setupPhoto(number: Int) {
        currentUser.photo = number
        viewModelScope.launch {
            userRepository.updateUsers(currentUser)
        }
    }
}