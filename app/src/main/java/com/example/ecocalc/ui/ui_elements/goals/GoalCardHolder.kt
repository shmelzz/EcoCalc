package com.example.ecocalc.ui.ui_elements.goals

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.enums.GoalProgress
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.utils.Goal
import com.example.ecocalc.databinding.GoalCardBinding

class GoalCardHolder(
    private val cardBinding: GoalCardBinding
) :
    RecyclerView.ViewHolder(cardBinding.root) {

    fun bindArticle(goal: Goal) {
        cardBinding.goalTitle.text = goal.title
        cardBinding.goalComplexity.text = goal.complexity.toString()
        when (goal.progress) {
            GoalProgress.EXPLORE -> {
                cardBinding.goalButton.text = "start"
                cardBinding.goalButton.setOnClickListener(View.OnClickListener { view ->
                    currentUser.goalsToExplore.remove(goal)
                    currentUser.inProgressGoals.add(goal)
                    goal.progress = GoalProgress.IN_PROGRESS
                })
            }
            GoalProgress.IN_PROGRESS -> {
                cardBinding.goalButton.text = "finish"
                cardBinding.goalButton.setOnClickListener(View.OnClickListener { view ->
                    currentUser.inProgressGoals.remove(goal)
                    currentUser.achievedGoals.add(goal)
                    goal.progress = GoalProgress.FINISHED
                })
            }
            else -> {
                cardBinding.goalButton.text = "done"
                cardBinding.goalButton.setOnClickListener(View.OnClickListener { view ->
                    Toast.makeText(
                        cardBinding.root.context,
                        "You've already done great!",
                        Toast.LENGTH_SHORT
                    ).show()
                })
            }
        }
    }
}