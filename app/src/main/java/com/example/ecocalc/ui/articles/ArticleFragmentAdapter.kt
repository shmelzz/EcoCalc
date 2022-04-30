package com.example.ecocalc.ui.articles

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecocalc.data.enums.ArticleCategory

class ArticleFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return OneArticleTypeFragment(ArticleCategory.ALL)
            1 -> return OneArticleTypeFragment(ArticleCategory.NEWS)
            2 -> return OneArticleTypeFragment(ArticleCategory.CARBON)
        }
        return OneArticleTypeFragment(ArticleCategory.CLIMATE)
    }

    override fun getItemCount(): Int {
        return 4
    }
}