package com.example.ecocalc.ui.ui_elements.goals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.utils.Goal
import com.example.ecocalc.databinding.GoalCardBinding
import com.example.ecocalc.ui.state_holders.goals.OneGoalTypeViewModel

class GoalCardAdapter(
    private val goals: List<Goal>,
    private val viewModel: OneGoalTypeViewModel
) :
    RecyclerView.Adapter<GoalCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalCardHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = GoalCardBinding.inflate(from, parent, false)
        return GoalCardHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: GoalCardHolder, position: Int) {
        holder.bindArticle(goals[position])
    }

    override fun getItemCount(): Int = goals.size
}