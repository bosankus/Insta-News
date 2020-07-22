package tech.androidplay.insta.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import tech.androidplay.insta.data.network.ApiService
import tech.androidplay.insta.data.repository.NewsRepository

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/18/2020, 6:39 PM
 */

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun getNewsRepository(apiService: ApiService): NewsRepository {
        return NewsRepository(apiService)
    }
}