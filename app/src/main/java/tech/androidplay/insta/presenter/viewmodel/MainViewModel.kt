package tech.androidplay.insta.presenter.viewmodel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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

    private var _newsData: LiveData<ResultData<News>> = MutableLiveData()
    val newsData: LiveData<ResultData<News>>
        get() = _newsData

    init {
        fetchNewsFromRoom()
    }

    private fun fetchNewsFromNetwork(keyword: String = "covid-19"): LiveData<ResultData<News>> {
        _newsData = liveData(block = {
            emit(ResultData.Loading())
            emit(newsRepository.fetchNews(keyword))
        })
        return _newsData
    }


    private fun fetchNewsFromRoom(): LiveData<ResultData<News>> {
        _newsData = liveData(block = {
            emit(ResultData.Loading())
            emit(newsRepository.getAllNews())
        })
        return _newsData
    }

}