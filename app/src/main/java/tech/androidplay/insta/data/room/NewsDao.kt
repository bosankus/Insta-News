package tech.androidplay.insta.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import tech.androidplay.insta.data.model.News

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 25/Aug/2020
 * Email: ankush@androidplay.in
 */

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNews(news: News)

    @Query("SELECT articles FROM news_table")
    fun getAllNews(): News

    @Delete
    fun deleteNews(news: News)
}