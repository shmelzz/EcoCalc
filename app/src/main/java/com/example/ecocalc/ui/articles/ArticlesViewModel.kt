package com.example.ecocalc.ui.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecocalc.data.utils.Article

class ArticlesViewModel : ViewModel() {

    private val _articles = MutableLiveData<ArrayList<Article>>().apply {
        value = arrayListOf()
    }
    val text: LiveData<ArrayList<Article>> = _articles
}