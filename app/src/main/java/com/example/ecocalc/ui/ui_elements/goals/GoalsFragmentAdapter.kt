package com.example.ecocalc.ui.ui_elements.goals

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecocalc.data.enums.GoalProgress
import com.example.ecocalc.data.user.UserDao
import com.example.ecocalc.ui.state_holders.goals.OneGoalTypeViewModel


class GoalsFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val userRepository: UserDao
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return OneGoalTypeFragment(
                GoalProgress.EXPLORE,
                OneGoalTypeViewModel(userRepository)
            )
            1 -> return OneGoalTypeFragment(
                GoalProgress.IN_PROGRESS,
                OneGoalTypeViewModel(userRepository)
            )
        }
        return OneGoalTypeFragment(GoalProgress.FINISHED, OneGoalTypeViewModel(userRepository))
    }

    override fun getItemCount(): Int {
        return 3
    }
}