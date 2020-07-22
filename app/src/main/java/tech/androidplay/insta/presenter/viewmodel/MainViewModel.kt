package tech.androidplay.insta.presenter.viewmodel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import tech.androidplay.insta.data.model.News
import tech.androidplay.insta.data.model.ResultData
import tech.androidplay.insta.data.repository.NewsRepository

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/18/2020, 4:01 PM
 */
class MainViewModel @ViewModelInject constructor(private val newsRepository: NewsRepository) :
    ViewModel() {

    private var _newsData: LiveData<News> = MutableLiveData()
    val newsData: LiveData<News>
        get() = _newsData

    fun fetchNews(keyword: String): LiveData<ResultData<News>> {
        return liveData(block = {
            emit(ResultData.Loading())
            emit(newsRepository.fetchNews(keyword))
        })
    }
}