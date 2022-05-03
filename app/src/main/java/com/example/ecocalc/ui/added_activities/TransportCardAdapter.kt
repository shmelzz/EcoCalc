package com.example.ecocalc.ui.added_activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.user_activity.TransportActivity
import com.example.ecocalc.databinding.AddedActivityCardBinding

class TransportCardAdapter(
    private val transports: List<TransportActivity>
) :
    RecyclerView.Adapter<TransportCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportCardHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = AddedActivityCardBinding.inflate(from, parent, false)
        return TransportCardHolder(binding)
    }

    override fun onBindViewHolder(holder: TransportCardHolder, position: Int) {
        holder.bindArticle(transports[position])
    }

    override fun getItemCount(): Int = transports.size
}