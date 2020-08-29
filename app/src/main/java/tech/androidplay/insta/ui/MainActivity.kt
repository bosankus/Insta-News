package tech.androidplay.insta.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import androidx.work.WorkInfo.State.ENQUEUED
import androidx.work.WorkInfo.State.RUNNING
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import tech.androidplay.insta.R
import tech.androidplay.insta.data.model.ResultData
import tech.androidplay.insta.presenter.viewmodel.MainViewModel
import tech.androidplay.insta.utility.HelperUtil.logMessage
import tech.androidplay.insta.presenter.adapter.NewsAdapter
import tech.androidplay.insta.utility.Constants.WORK_MANAGER_TAG
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var workManager: WorkManager

    @Inject
    lateinit var oneTimeWorkRequest: OneTimeWorkRequest

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        startWorkManager()

//        fetchNewsFromDB()
    }


    /*private fun lodData() {

        rvNewsList.adapter = newsAdapter

        mainViewModel.newsData.observe(this, {
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
    }*/


    /*private fun fetchNewsFromDB() {

        rvNewsList.adapter = newsAdapter

        mainViewModel.newsData.observe(this, {
            when (it) {
                is ResultData.Success -> {
                    logMessage("Ankush ${it.data}")
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
    }*/

    private fun startWorkManager() {
        /*if (workManager.getWorkInfosByTag(WORK_MANAGER_TAG).get()[0].state == ENQUEUED) {

        }*/
        workManager.enqueue(oneTimeWorkRequest)
        workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this, {
                logMessage(it.state.name)
            })
    }
}