package tech.androidplay.insta.workmanager

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import tech.androidplay.insta.data.model.News
import tech.androidplay.insta.data.model.ResultData
import tech.androidplay.insta.data.repository.NewsRepository
import tech.androidplay.insta.utility.HelperUtil.logMessage
import javax.inject.Inject

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 26/Aug/2020
 * Email: ankush@androidplay.in
 */


class FetchNewsWorker @WorkerInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    val newsRepository: NewsRepository
): CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            newsRepository.fetchAndSaveNewsToDB("top")
            Result.success()
        } catch (e: InterruptedException) {
            logMessage("Worker error: $e")
            Result.failure()
        }
    }

}