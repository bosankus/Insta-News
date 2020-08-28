package tech.androidplay.insta.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import tech.androidplay.insta.R
import tech.androidplay.insta.data.model.News.Article

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/23/2020, 12:54 AM
 */
class NewsAdapter : ListAdapter<Article, NewsViewHolder>(NewsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_news_list_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = getItem(position)
        holder.bind(newsItem)
    }
}