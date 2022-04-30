package com.example.ecocalc.ui.goals

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecocalc.data.enums.GoalProgress


class GoalsFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return OneGoalTypeFragment(GoalProgress.EXPLORE)
            1 -> return OneGoalTypeFragment(GoalProgress.IN_PROGRESS)
        }
        return OneGoalTypeFragment(GoalProgress.FINISHED)
    }

    override fun getItemCount(): Int {
        return 3
    }
}