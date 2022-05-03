package com.example.ecocalc.ui.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.ecocalc.databinding.FragmentGoalsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class GoalsFragment : Fragment() {

   private val goalProgressArray = arrayOf(
        "Explore",
        "In progress",
        "Finished"
    )

    private var _binding: FragmentGoalsBinding? = null

    private lateinit var adapter: GoalsFragmentAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGoalsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewPager = binding.viewpager
        tabLayout = binding.goalsTabs

        adapter = GoalsFragmentAdapter(activity!!.supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = goalProgressArray[position]
        }.attach()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}