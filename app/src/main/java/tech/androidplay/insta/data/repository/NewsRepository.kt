package tech.androidplay.insta.data.repository

import tech.androidplay.insta.data.model.News
import tech.androidplay.insta.data.model.ResultData
import tech.androidplay.insta.data.network.ApiService
import javax.inject.Inject

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/18/2020, 6:33 PM
 */
class NewsRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun fetchNews(keyword: String): ResultData<News> {
        val result = apiService.getNews(keyword)
        return ResultData.Success(result)
    }
}