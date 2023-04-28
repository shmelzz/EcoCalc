package com.example.ecocalc.ui.state_holders.added_activities

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.data.user_activity.TransportActivity

class AddedActivitiesDialogViewModel : ViewModel() {

    fun getAddedPlasticActivities(): List<PlasticActivity> {
        return currentUser.plasticActivities
    }

    fun getAddedMealActivities(): List<MealActivity> {
        return currentUser.mealActivities
    }

    fun getAddedTransportActivities(): List<TransportActivity> {
        return currentUser.transportActivities
    }
}