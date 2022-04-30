package com.example.ecocalc.ui.activity_add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecocalc.data.user.currentUser

class ActivityAddViewModel : ViewModel() {
    private val totalCarbon = MutableLiveData<String>().apply {
        value = currentUser.carbonPrint.toString()
    }
    val text: LiveData<String> = totalCarbon
}