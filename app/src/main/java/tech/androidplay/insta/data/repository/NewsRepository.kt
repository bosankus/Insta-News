package tech.androidplay.insta.data.repository

import androidx.lifecycle.LiveData
import tech.androidplay.insta.data.model.News
import tech.androidplay.insta.data.model.ResultData
import tech.androidplay.insta.data.network.ApiService
import tech.androidplay.insta.data.room.NewsDao
import javax.inject.Inject

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/18/2020, 6:33 PM
 */
class NewsRepository @Inject constructor(
    private val apiService: ApiService,
    private val newsDao: NewsDao
) {

    suspend fun fetchNews(keyword: String): ResultData<News> {
        val result = apiService.getNews(keyword)
        return ResultData.Success(result)
    }

    // Fetching from Room
    fun getAllNews(): ResultData<News> {
        val result = newsDao.getAllNews()
        return ResultData.Success(result)
    }
}