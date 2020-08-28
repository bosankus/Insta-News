package tech.androidplay.insta.presenter.adapter

import androidx.recyclerview.widget.DiffUtil
import tech.androidplay.insta.data.model.News

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/23/2020, 12:54 AM
 */
class NewsDiffUtil : DiffUtil.ItemCallback<News.Article>() {
    override fun areItemsTheSame(oldItem: News.Article, newItem: News.Article): Boolean {
        return newItem.source?.id == oldItem.source?.id
    }

    override fun areContentsTheSame(oldItem: News.Article, newItem: News.Article): Boolean {
        return newItem == oldItem
    }
}