package com.example.ecocalc.data.utils

import com.example.ecocalc.data.enums.ArticleCategory
import java.util.*

var articleList = mutableListOf<Article>()
var newsArticleList = mutableListOf<Article>()
var carbonArticleList = mutableListOf<Article>()
var climateArticleList = mutableListOf<Article>()

class Article(
    val title: String,
    val content: String,
    val link: String,
    val category: ArticleCategory,
    val id: Int? = articleList.size
)

fun setArticles() {
    val article1 = Article(
        "WWF",
        "WWF",
        "https://www.worldwildlife.org/",
        ArticleCategory.NEWS
    )
    articleList.add(article1)

    val article2 = Article(
        "fffffffffff",
        "ddsddffdoldodnffdnjodndlknddokndoidjndoidjiojdhipdjdpdjpdjdiojhdpidjdpdjpdhdjhpd",
        "fddff",
        ArticleCategory.NEWS
    )
    articleList.add(article2)

    val article4 = Article(
        "asddddddddddddddd",
        "dddff",
        "ffddf",
        ArticleCategory.NEWS
    )
    articleList.add(article4)
    articleList.add(article4)
}

fun setNewsArticles() {
    val article1 = Article(
        "WWF",
        "WWF",
        "https://www.worldwildlife.org/",
        ArticleCategory.NEWS
    )
    newsArticleList.add(article1)

    val article2 = Article(
        "fffffffffff",
        "ddsddffdoldodnffdnjodndlknddokndoidjndoidjiojdhipdjdpdjpdjdiojhdpidjdpdjpdhdjhpd",
        "fddff",
        ArticleCategory.NEWS
    )
    newsArticleList.add(article2)
}

fun setCarbonArticles() {
    val article1 = Article(
        "WWF",
        "WWF",
        "https://www.worldwildlife.org/",
        ArticleCategory.CARBON
    )
    carbonArticleList.add(article1)

    val article2 = Article(
        "fffffffffff",
        "ddsddffdoldodnffdnjodndlknddokndoidjndoidjiojdhipdjdpdjpdjdiojhdpidjdpdjpdhdjhpd",
        "fddff",
        ArticleCategory.CARBON
    )
    carbonArticleList.add(article2)

    val article4 = Article(
        "asddddddddddddddd",
        "dddff",
        "ffddf",
        ArticleCategory.CARBON
    )
    carbonArticleList.add(article4)
}

fun setClimateArticles() {
    val article1 = Article(
        "WWF",
        "WWF",
        "https://www.worldwildlife.org/",
        ArticleCategory.CLIMATE
    )
    climateArticleList.add(article1)
}

