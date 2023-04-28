package com.example.ecocalc.ui.ui_elements.added_activities

import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.user_activity.TransportActivity
import com.example.ecocalc.databinding.AddedActivityCardBinding

class TransportCardHolder(
    private val cardBinding: AddedActivityCardBinding
) :
    RecyclerView.ViewHolder(cardBinding.root) {

    fun bindArticle(activity: TransportActivity) {
        cardBinding.typeInfo.text = "Transport: ${activity.type.toString()}"
        cardBinding.dateInfo.text = activity.date
        cardBinding.carbonInputInfo.text = "Carbon print: ${activity.carbonInput.toString()} kg"
    }
}