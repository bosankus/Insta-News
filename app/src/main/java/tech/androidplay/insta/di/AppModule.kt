package tech.androidplay.insta.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import tech.androidplay.insta.presenter.adapter.NewsAdapter
import javax.inject.Singleton

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 29/Aug/2020
 * Email: ankush@androidplay.in
 */

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesNewsAdapter(): NewsAdapter {
        return NewsAdapter()
    }
}