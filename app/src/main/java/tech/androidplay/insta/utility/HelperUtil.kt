package tech.androidplay.insta.utility

import android.util.Log

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/18/2020, 9:09 PM
 */
object HelperUtil {

    fun logMessage(message: String, situation: String = "BASIC") {
        Log.d("Androidplay", "$situation: $message")
    }
}