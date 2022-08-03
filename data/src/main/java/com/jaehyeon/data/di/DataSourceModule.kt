package com.jaehyeon.data.di

import com.jaehyeon.data.remote.data_source.WeatherApi
import com.jaehyeon.data.remote.impl.WeatherDataApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Jaehyeon on 2022/08/03.
 */
@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideWeatherDataSource(
        retrofit: Retrofit
    ): WeatherApi {
        return WeatherDataApiImpl(retrofit)
    }

}