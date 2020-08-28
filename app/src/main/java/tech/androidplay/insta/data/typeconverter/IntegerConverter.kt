package tech.androidplay.insta.data.typeconverter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tech.androidplay.insta.data.model.News
import java.io.ByteArrayOutputStream
import java.util.*

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 26/Aug/2020
 * Email: ankush@androidplay.in
 */

class IntegerConverter {

    @TypeConverter
    fun toString(value: Int): String = value.toString()

    @TypeConverter
    fun toInt(value: String): Int = value.toInt()
}