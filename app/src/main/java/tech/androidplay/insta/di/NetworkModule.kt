package tech.androidplay.insta.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import tech.androidplay.insta.data.network.ApiService
import tech.androidplay.insta.data.repository.NewsRepository
import tech.androidplay.insta.data.room.NewsDao
import tech.androidplay.insta.data.room.NewsDatabase
import tech.androidplay.insta.utility.Constants.DATABASE_NAME
import tech.androidplay.insta.utility.NetworkConstants.BASE_URL
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Androidplay
 * Author: Ankush
 * On: 7/18/2020, 5:23 PM
 */

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(
        @ApplicationContext app: Context
    ) : NewsDatabase =
        Room.databaseBuilder(
            app,
            NewsDatabase::class.java,
            DATABASE_NAME
        ).build()


    @Singleton
    @Provides
    fun provideNewsDao(db: NewsDatabase) = db.getNewsDao()


    @Provides
    fun getBaseUrl(): String {
        return BASE_URL
    }

    @Provides
    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun getConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun getRetrofit(
        baseUrl: String,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun getNewsRepository(apiService: ApiService, newsDao: NewsDao): NewsRepository {
        return NewsRepository(apiService, newsDao)
    }
}