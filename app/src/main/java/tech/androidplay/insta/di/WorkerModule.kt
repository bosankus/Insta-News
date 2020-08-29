package tech.androidplay.insta.di

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import tech.androidplay.insta.data.repository.NewsRepository
import tech.androidplay.insta.utility.Constants.WORK_MANAGER_TAG
import tech.androidplay.insta.workmanager.FetchNewsWorker
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 29/Aug/2020
 * Email: ankush@androidplay.in
 */

@Module
@InstallIn(ApplicationComponent::class)
class WorkerModule {

    @Singleton
    @Provides
    fun providesWorkManager(
        @ApplicationContext app: Context
    ): WorkManager {
        return WorkManager.getInstance(app.applicationContext)
    }


    @Singleton
    @Provides
    fun providesConstraints(): Constraints {
        return Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
    }


    @Singleton
    @Provides
    fun providesOneTimeWorkRequest(
        constraints: Constraints
    ): OneTimeWorkRequest {
        return OneTimeWorkRequest.Builder(
            FetchNewsWorker::class.java
        )
            .setInitialDelay(5, TimeUnit.SECONDS)
            .addTag(WORK_MANAGER_TAG)
            .setConstraints(constraints)
            .build()
    }
}