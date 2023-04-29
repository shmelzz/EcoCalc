package com.example.ecocalc.ui.ui_elements.goals

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.enums.GoalProgress
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.utils.Goal
import com.example.ecocalc.databinding.GoalCardBinding
import com.example.ecocalc.ui.state_holders.goals.OneGoalTypeViewModel

class GoalCardHolder(
    private val cardBinding: GoalCardBinding,
    private val viewModel: OneGoalTypeViewModel
) :
    RecyclerView.ViewHolder(cardBinding.root) {

    fun bindArticle(goal: Goal) {
        cardBinding.goalTitle.text = goal.title
        cardBinding.goalComplexity.text = goal.complexity.toString()
        when (goal.progress) {
            GoalProgress.EXPLORE -> {
                cardBinding.goalButton.text = "start"
                cardBinding.goalButton.setOnClickListener {
                    viewModel.updateGoalFromExplore(goal)
                }
            }
            GoalProgress.IN_PROGRESS -> {
                cardBinding.goalButton.text = "finish"
                cardBinding.goalButton.setOnClickListener {
                    viewModel.updateGoalFromInProgress(goal)
                }
            }
            else -> {
                cardBinding.goalButton.text = "done"
                cardBinding.goalButton.setOnClickListener {
                    Toast.makeText(
                        cardBinding.root.context,
                        "You've already done great!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}