package tech.androidplay.insta.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_news_list_item.view.*
import tech.androidplay.insta.data.model.News

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/23/2020, 12:54 AM
 */
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(newsItem: News.Article) {
        itemView.tvNewsTitle.text = newsItem.title
        Glide.with(itemView.context)
            .load(newsItem.urlToImage)
            .centerCrop()
            .into(itemView.imgNews)
    }
}