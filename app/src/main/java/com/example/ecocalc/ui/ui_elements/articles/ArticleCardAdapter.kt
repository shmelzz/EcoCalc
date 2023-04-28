package com.example.ecocalc.ui.ui_elements.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.utils.Article
import com.example.ecocalc.databinding.ArticleCardBinding

class ArticleCardAdapter(
    private val articles: List<Article>,
    private val onItemClicked: (position: Int) -> Unit
) :
    RecyclerView.Adapter<ArticleCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleCardHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ArticleCardBinding.inflate(from, parent, false)
        return ArticleCardHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ArticleCardHolder, position: Int) {
        holder.bindArticle(articles[position])
    }

    override fun getItemCount(): Int = articles.size
}