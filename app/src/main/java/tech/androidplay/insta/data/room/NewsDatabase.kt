package tech.androidplay.insta.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tech.androidplay.insta.data.model.News
import tech.androidplay.insta.data.typeconverter.IntegerConverter
import tech.androidplay.insta.data.typeconverter.ArticleConverter
import tech.androidplay.insta.data.typeconverter.SourceConverter

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 25/Aug/2020
 * Email: ankush@androidplay.in
 */

@Database(
    entities = [News::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ArticleConverter::class,
    IntegerConverter::class,
    SourceConverter::class
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao
}