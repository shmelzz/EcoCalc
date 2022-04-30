package com.example.ecocalc.ui.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.ecocalc.databinding.FragmentArticlesBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ArticlesFragment : Fragment() {

    private val articlesProgressArray = arrayOf(
        "All",
        "News",
        "Carbon",
        "Climate"
    )

    private lateinit var articlesViewModel: ArticlesViewModel
    private var _binding: FragmentArticlesBinding? = null

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: ArticleFragmentAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articlesViewModel =
            ViewModelProvider(this).get(ArticlesViewModel::class.java)
        _binding = FragmentArticlesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewPager = binding.viewpagerArticles
        tabLayout = binding.articlesTabs

        adapter = ArticleFragmentAdapter(activity!!.supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = articlesProgressArray[position]
        }.attach()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}