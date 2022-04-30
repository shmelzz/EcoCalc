package com.example.ecocalc.data.utils

import com.example.ecocalc.data.enums.GoalComplexity
import com.example.ecocalc.data.enums.GoalProgress
import com.example.ecocalc.data.user.currentUser
import kotlinx.serialization.Serializable


@Serializable
data class Goal(
    val title: String,
    val complexity: GoalComplexity,
    var progress: GoalProgress
)

fun setGoals() {
    val goal1 = Goal(
        "asdfghjkl",
        GoalComplexity.EASY,
        GoalProgress.EXPLORE
    )
    currentUser.goalsToExplore.add(goal1)
    currentUser.goalsToExplore.add(goal1)
    currentUser.goalsToExplore.add(goal1)

    currentUser.inProgressGoals.add(Goal("dnkld", GoalComplexity.MEDIUM, GoalProgress.IN_PROGRESS))
}
