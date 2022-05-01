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
    currentUser.goalsToExplore.add(
        Goal(
            "Switch off any unnecessary lights during the day time",
            GoalComplexity.MEDIUM,
            GoalProgress.EXPLORE
        )
    )

    currentUser.goalsToExplore.add(
        Goal(
            "Select days fo the week which you do not eat any meat",
            GoalComplexity.EASY,
            GoalProgress.EXPLORE
        )
    )

    currentUser.goalsToExplore.add(
        Goal(
            "Replace red meat with lower impact meat and fish",
            GoalComplexity.EASY,
            GoalProgress.EXPLORE
        )
    )

    currentUser.goalsToExplore.add(
        Goal(
            "Find shop with local products",
            GoalComplexity.MEDIUM,
            GoalProgress.EXPLORE
        )
    )

    currentUser.goalsToExplore.add(
        Goal(
            "Avoid food waste, cook as much as you and your family can eat",
            GoalComplexity.MEDIUM,
            GoalProgress.EXPLORE
        )
    )

    currentUser.goalsToExplore.add(
        Goal(
            "Try to get to your work not by your car (walking, bus, train, eth.)",
            GoalComplexity.HARD,
            GoalProgress.EXPLORE
        )
    )
}
