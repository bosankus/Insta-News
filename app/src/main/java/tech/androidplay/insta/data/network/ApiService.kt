package tech.androidplay.insta.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import tech.androidplay.insta.data.model.News
import tech.androidplay.insta.utility.NetworkConstants.API_KEY

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/18/2020, 5:55 PM
 */
interface ApiService {

    @GET("/v2/everything")
    suspend fun getNews(
        @Query("q") keyword: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): News

}