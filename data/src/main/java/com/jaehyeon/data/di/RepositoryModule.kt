package com.jaehyeon.data.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.jaehyeon.data.WeatherRepositoryImpl
import com.jaehyeon.data.remote.data_source.WeatherApi
import com.jaehyeon.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        source: WeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(source)
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }
}