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
class SourceConverter {

    @TypeConverter
    fun toString(source: News.Article.Source): String {
        val type = object : TypeToken<News.Article.Source>() {}.type
        return Gson().toJson(source, type)
    }

    @TypeConverter
    fun fromString(source: String): News.Article.Source {
        val type = object : TypeToken<News.Article.Source>() {}.type
        return Gson().fromJson(source, type)
    }
}