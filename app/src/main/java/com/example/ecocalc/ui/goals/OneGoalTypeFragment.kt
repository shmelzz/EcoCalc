package com.example.ecocalc.ui.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecocalc.data.enums.GoalProgress
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.utils.setGoals
import com.example.ecocalc.databinding.FragmentGoalListBinding

class OneGoalTypeFragment(goalProgress: GoalProgress) : Fragment() {
    // private lateinit var articlesViewModel: ArticlesViewModel
    private var _binding: FragmentGoalListBinding? = null
    private val binding get() = _binding!!

    private val fragmentGoalProgress: GoalProgress = goalProgress

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // articlesViewModel =
        // ViewModelProvider(this).get(ArticlesViewModel::class.java)

        _binding = FragmentGoalListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        if (currentUser.achievedGoals.isEmpty() && currentUser.inProgressGoals.isEmpty()
            && currentUser.goalsToExplore.isEmpty()
        ) {
            setGoals()
            val userDao = UserDatabase.getDataBase(requireActivity().application).userDao()
            userDao.updateUsers(currentUser)
        }

        when (fragmentGoalProgress) {
            GoalProgress.EXPLORE -> {
                binding.goalsList.apply {
                    layoutManager = LinearLayoutManager(context)
                    // TODO
                    adapter = GoalCardAdapter(currentUser.goalsToExplore)
                }
            }
            GoalProgress.IN_PROGRESS -> {
                binding.goalsList.apply {
                    layoutManager = LinearLayoutManager(context)
                    // TODO
                    adapter = GoalCardAdapter(currentUser.inProgressGoals)
                }
            }
            else -> {
                binding.goalsList.apply {
                    layoutManager = LinearLayoutManager(context)
                    // TODO
                    adapter = GoalCardAdapter(currentUser.achievedGoals)
                }
            }
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}