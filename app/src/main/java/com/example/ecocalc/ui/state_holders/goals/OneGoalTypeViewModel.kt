package com.example.ecocalc.ui.state_holders.goals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecocalc.data.enums.GoalProgress
import com.example.ecocalc.data.user.UserDao
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.utils.Goal
import kotlinx.coroutines.launch

class OneGoalTypeViewModel(
    private val userRepository: UserDao
) : ViewModel() {

    fun getGoals(type: GoalProgress): List<Goal> {
        return when (type) {
            GoalProgress.EXPLORE -> {
                currentUser.goalsToExplore
            }
            GoalProgress.IN_PROGRESS -> {
                currentUser.inProgressGoals
            }
            else -> {
                currentUser.achievedGoals
            }
        }
    }

    fun updateGoalFromExplore(goal: Goal) {
        currentUser.goalsToExplore.remove(goal)
        currentUser.inProgressGoals.add(goal)
        goal.progress = GoalProgress.IN_PROGRESS
        viewModelScope.launch {
            userRepository.updateGoal(goal)
        }
    }

    fun updateGoalFromInProgress(goal: Goal) {
        currentUser.inProgressGoals.remove(goal)
        currentUser.achievedGoals.add(goal)
        goal.progress = GoalProgress.FINISHED
        viewModelScope.launch {
            userRepository.updateGoal(goal)
        }
    }
}