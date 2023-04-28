package com.example.ecocalc.ui.ui_elements.added_activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.databinding.AddedActivityCardBinding

class PlasticCardAdapter(
    private val plastics: List<PlasticActivity>
) :
    RecyclerView.Adapter<PlasticCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlasticCardHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = AddedActivityCardBinding.inflate(from, parent, false)
        return PlasticCardHolder(binding)
    }

    override fun onBindViewHolder(holder: PlasticCardHolder, position: Int) {
        holder.bindArticle(plastics[position])
    }

    override fun getItemCount(): Int = plastics.size
}