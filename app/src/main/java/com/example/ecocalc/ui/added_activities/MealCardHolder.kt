package com.example.ecocalc.ui.added_activities

import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.databinding.AddedActivityCardBinding

class MealCardHolder(
    private val cardBinding: AddedActivityCardBinding
) :
    RecyclerView.ViewHolder(cardBinding.root) {

    fun bindArticle(activity: MealActivity) {
        cardBinding.typeInfo.text = "Meal: ${activity.type.toString()}"
        cardBinding.dateInfo.text = activity.date
        cardBinding.carbonInputInfo.text = "Carbon print: ${activity.carbonInput.toString()} kg"
    }
}