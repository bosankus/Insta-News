package tech.androidplay.insta.data.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tech.androidplay.insta.data.model.News

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 28/Aug/2020
 * Email: ankush@androidplay.in
 */
class ArticleConverter {

    @TypeConverter
    fun toJson(value: List<News.Article>): String? {
        val type = object : TypeToken<List<News.Article>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun fromJson(value: String): List<News.Article> {
        val type = object : TypeToken<List<News.Article>>() {}.type
        return Gson().fromJson(value, type)
    }
}