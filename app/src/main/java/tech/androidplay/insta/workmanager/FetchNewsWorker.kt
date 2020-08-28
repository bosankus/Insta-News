package tech.androidplay.insta.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import javax.inject.Inject

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 26/Aug/2020
 * Email: ankush@androidplay.in
 */

class FetchNewsWorker @Inject constructor(
    context: Context,
    workerParameters: WorkerParameters
) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}