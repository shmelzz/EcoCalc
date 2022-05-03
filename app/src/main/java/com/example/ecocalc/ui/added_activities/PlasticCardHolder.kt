package com.example.ecocalc.ui.added_activities

import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.databinding.AddedActivityCardBinding

class PlasticCardHolder(
    private val cardBinding: AddedActivityCardBinding
) :
    RecyclerView.ViewHolder(cardBinding.root) {

    fun bindArticle(activity: PlasticActivity) {
        cardBinding.typeInfo.text = "Plastic: ${activity.type.toString()}"
        cardBinding.dateInfo.text = activity.date
        cardBinding.carbonInputInfo.text = "Carbon print: ${activity.carbonInput.toString()} kg"
    }
}