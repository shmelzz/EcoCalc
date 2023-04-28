package com.example.ecocalc.ui.ui_elements.articles

import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.data.utils.Article
import com.example.ecocalc.databinding.ArticleCardBinding

class ArticleCardHolder(
    private val cardBinding: ArticleCardBinding,
    onItemClicked: (Int) -> Unit
) :
    RecyclerView.ViewHolder(cardBinding.root) {

    init {
        itemView.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun bindArticle(article: Article) {
        cardBinding.articleTitle.text = article.title
        cardBinding.articleContentText.text = article.content
        cardBinding.articleType.text = article.category.toString()
    }
}