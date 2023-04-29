package com.example.ecocalc.ui.ui_elements.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecocalc.data.enums.GoalProgress
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.databinding.FragmentGoalListBinding
import com.example.ecocalc.ui.state_holders.activity_add.MealDialogViewModel
import com.example.ecocalc.ui.state_holders.goals.OneGoalTypeViewModel
import kotlinx.coroutines.launch

class OneGoalTypeFragment(
    goalProgress: GoalProgress,
    private val viewModel: OneGoalTypeViewModel
) :
    Fragment() {

    private var _binding: FragmentGoalListBinding? = null
    private val binding get() = _binding!!

    private val fragmentGoalProgress: GoalProgress = goalProgress

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGoalListBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val userDao =
//            UserDatabase.getDataBase(requireActivity().application).userDao()
//        lifecycleScope.launch {
//            userDao.updateUsers(currentUser)
//        }
        updateGoalsList()
        return root
    }

    private fun updateGoalsList() {
        binding.goalsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = GoalCardAdapter(viewModel.getGoals(fragmentGoalProgress), viewModel)
        }
    }

    override fun onResume() {
        super.onResume()
        updateGoalsList()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}