package tech.androidplay.insta.data.model

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/18/2020, 6:20 PM
 */
sealed class ResultData<out T> {
    data class Success<out T>(val data: T? = null): ResultData<T>()
    data class Loading(val nothing: Nothing? = null): ResultData<Nothing>()
    data class Failed(val message: String? = null): ResultData<Nothing>()
    data class Exception(val message: String?  = null): ResultData<Nothing>()
}