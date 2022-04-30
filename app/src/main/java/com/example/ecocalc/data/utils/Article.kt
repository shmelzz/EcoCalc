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
    setCarbonArticles()
    setClimateArticles()
    setNewsArticles()
    articleList.addAll(carbonArticleList)
    articleList.addAll(climateArticleList)
    articleList.addAll(newsArticleList)
}

fun setNewsArticles() {
    newsArticleList.add(
        Article(
            "How mountain streams signal climate change",
            "A new tool can better assess an important but overlooked indicator of global" +
                    " warming: the variety of bugs, worms, and snails living in high mountain streams.",
            "https://www.sciencedaily.com/releases/2022/04/220407101015.htm",
            ArticleCategory.NEWS
        )
    )

    newsArticleList.add(
        Article(
            "Climate change will reshuffle marine ecosystems in unexpected ways",
            "Warming of the oceans due to climate change will mean fewer productive fish " +
                    "species to catch in the future, according to a new study that found as " +
                    "temperatures warm, predator-prey interactions will prevent species from " +
                    "keeping up with the conditions where they could thrive.",
            "https://www.sciencedaily.com/releases/2022/04/220412203108.htm",
            ArticleCategory.NEWS
        )
    )

    newsArticleList.add(
        Article(
            "Private protected areas help conserve overlooked and threatened regions",
            "New research shows that private protected areas help conserve underrepresented " +
                    "biomes and highly threatened regions. Researchers have assessed 17,561 " +
                    "privately protected areas in 15 countries across five continents. Their " +
                    "findings reveal that compared to state protected areas, PPAs are twice as " +
                    "likely to be in areas with the greatest human disturbance, such as regions " +
                    "used for agriculture and mining.",
            "https://www.sciencedaily.com/releases/2022/04/220407141854.htm",
            ArticleCategory.NEWS
        )
    )
}

fun setCarbonArticles() {
    carbonArticleList.add(
        Article(
            "How to Reduce Your Carbon Footprint",
            "Climate change can be overwhelming. The science is complex, " +
                    "and when it comes to future impacts, there are still a lot of unknowns. " +
                    "While real solutions will require action on a global scale, there are choices " +
                    "you can make in your day-to-day life to lessen your personal impact on the " +
                    "environment. This guide will walk you through some of them.",
            "https://www.nytimes.com/guides/year-of-living-better/how-to-reduce-your-carbon-footprint",
            ArticleCategory.CARBON
        )
    )

    carbonArticleList.add(
        Article(
            "Harmonizing corporate carbon footprints",
            "The framework we present may help companies, investors, and policy makers to " +
                    "identify and close the gaps in corporate carbon footprints.",
            "https://www.nature.com/articles/s41467-021-26349-x",
            ArticleCategory.CARBON
        )
    )

    carbonArticleList.add(
        Article(
            "Carbon footprint gap between rich and poor expanding, study finds",
            "Researchers say cutting carbon footprint of world’s wealthiest may be fastest " +
                    "way to reach net zero",
            "https://www.theguardian.com/environment/2022/feb/04/carbon-footprint-gap-between-" +
                    "rich-poor-expanding-study",
            ArticleCategory.CARBON
        )
    )

    carbonArticleList.add(
        Article(
            "The Importance of Carbon Footprint Estimation Boundaries",
            " We suggest that firms use the screening-level analysis described here to set " +
                    "the bounds of their foot printing strategy to ensure that they do not ignore " +
                    "large sources of environmental effects across their supply chains.",
            "https://pubs.acs.org/doi/10.1021/es703112w",
            ArticleCategory.CARBON
        )
    )
}

fun setClimateArticles() {
    climateArticleList.add(
        Article(
            "WWF",
            "WWF",
            "https://www.worldwildlife.org/",
            ArticleCategory.CLIMATE
        )
    )

    climateArticleList.add(
        Article(
            "The Science of Climate Change Explained: Facts, Evidence and Proof",
            "Definitive answers to the big questions.",
            "https://www.nytimes.com/article/climate-change-global-warming-faq.html",
            ArticleCategory.CLIMATE
        )
    )

    climateArticleList.add(
        Article(
            "Global climate change",
            "NASA",
            "https://climate.nasa.gov/",
            ArticleCategory.CLIMATE
        )
    )

    climateArticleList.add(
        Article(
            "Climate Change 2022: Impacts, Adaptation and Vulnerability",
            "The Working Group II contribution to the IPCC Sixth Assessment Report assesses " +
                    "the impacts of climate change, looking at ecosystems, biodiversity, and human " +
                    "communities at global and regional levels. It also reviews vulnerabilities " +
                    "and the capacities and limits of the natural world and human societies to adapt" +
                    " to climate change.",
            "https://www.ipcc.ch/report/ar6/wg2/",
            ArticleCategory.CLIMATE
        )
    )
}

