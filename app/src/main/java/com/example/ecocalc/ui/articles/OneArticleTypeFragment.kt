package com.example.ecocalc.ui.articles

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecocalc.data.enums.ArticleCategory
import com.example.ecocalc.data.utils.*
import com.example.ecocalc.databinding.FragmentArticlesListBinding

class OneArticleTypeFragment(articleCategory: ArticleCategory) : Fragment() {
    private var _binding: FragmentArticlesListBinding? = null
    private val binding get() = _binding!!

    private val fragmentArticleCategory: ArticleCategory = articleCategory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticlesListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        when (fragmentArticleCategory) {
            ArticleCategory.ALL -> {
                if (articleList.isEmpty()) {
                    setArticles()
                }
                binding.articlesList.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = ArticleCardAdapter(articleList) {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse(articleList[it].link)
                        startActivity(openURL)
                    }
                }
            }
            ArticleCategory.NEWS -> {
                if (newsArticleList.isEmpty()) {
                    setNewsArticles()
                }
                binding.articlesList.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = ArticleCardAdapter(newsArticleList) {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse(newsArticleList[it].link)
                        startActivity(openURL)
                    }
                }
            }
            ArticleCategory.CARBON -> {
                if (carbonArticleList.isEmpty()) {
                    setCarbonArticles()
                }
                binding.articlesList.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = ArticleCardAdapter(carbonArticleList) {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse(carbonArticleList[it].link)
                        startActivity(openURL)
                    }
                }
            }
            else -> {
                if (climateArticleList.isEmpty()) {
                    setClimateArticles()
                }
                binding.articlesList.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = ArticleCardAdapter(climateArticleList) {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse(climateArticleList[it].link)
                        startActivity(openURL)
                    }
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