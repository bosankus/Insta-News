package tech.androidplay.insta.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import tech.androidplay.insta.R
import tech.androidplay.insta.data.model.ResultData
import tech.androidplay.insta.presenter.viewmodel.MainViewModel
import tech.androidplay.insta.utility.HelperUtil.logMessage
import tech.androidplay.insta.view.adapter.NewsAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        lodData()
    }


    private fun lodData() {

        val newsAdapter = NewsAdapter()

        rvNewsList.adapter = newsAdapter

        val loadNews = mainViewModel.fetchNews("politics")
        loadNews.observe(this, Observer {
            when (it) {
                is ResultData.Success -> {
                    newsAdapter.submitList(it.data?.articles)
                }
                is ResultData.Loading -> {
                    logMessage("News Loading...")
                }
                is ResultData.Failed -> {
                    logMessage("News loading failed")
                }
                is ResultData.Exception -> {
                    logMessage("We got some exception")
                }
            }
        })
    }
}