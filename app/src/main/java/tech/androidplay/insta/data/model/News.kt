package tech.androidplay.insta.data.model


import androidx.room.*
import com.google.gson.annotations.SerializedName
import tech.androidplay.insta.data.typeconverter.IntegerConverter
import tech.androidplay.insta.data.typeconverter.ArticleConverter
import tech.androidplay.insta.utility.Constants.DATABASE_NAME

@Entity(tableName = DATABASE_NAME)
data class News(

    @SerializedName("articles")
    val articles: List<Article>,

    @SerializedName("status")
    val status: String?,

    @SerializedName("totalResults")
    val totalResults: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    data class Article(

        @ColumnInfo(name = "athr")
        @SerializedName("author")
        val author: String?,

        @ColumnInfo(name = "cntnt")
        @SerializedName("content")
        val content: String?,

        @ColumnInfo(name = "desc")
        @SerializedName("description")
        val description: String?,

        @ColumnInfo(name = "publsh")
        @SerializedName("publishedAt")
        val publishedAt: String?,

        @ColumnInfo(name = "src")
        @SerializedName("source")
        val source: Source?,

        @ColumnInfo(name = "title_txt")
        @SerializedName("title")
        val title: String?,

        @ColumnInfo(name = "link")
        @SerializedName("url")
        val url: String?,

        @SerializedName("urlToImage")
        val urlToImage: String?
    ) {
        data class Source(

            @SerializedName("id")
            val id: String?,

            @SerializedName("name")
            val name: String
        )
    }
}