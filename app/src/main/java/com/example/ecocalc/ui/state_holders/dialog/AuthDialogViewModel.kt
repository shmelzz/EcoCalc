package com.example.ecocalc.ui.state_holders.dialog

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthDialogViewModel: ViewModel() {

    fun changePassword(newPassword: String) {
        val user = Firebase.auth.currentUser
        user?.updatePassword(newPassword)
    }

    fun changeEmail(newEmail: String) {
        val user = Firebase.auth.currentUser
        user?.updateEmail(newEmail)
    }
}