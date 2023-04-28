package com.example.ecocalc.ui.ui_elements.added_activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.databinding.AddedActivityCardBinding

class MealCardAdapter(
    private val meals: List<MealActivity>
) :
    RecyclerView.Adapter<MealCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealCardHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = AddedActivityCardBinding.inflate(from, parent, false)
        return MealCardHolder(binding)
    }

    override fun onBindViewHolder(holder: MealCardHolder, position: Int) {
        holder.bindArticle(meals[position])
    }

    override fun getItemCount(): Int = meals.size
}