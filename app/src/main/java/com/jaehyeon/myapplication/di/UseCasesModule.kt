package com.jaehyeon.myapplication.di

import com.jaehyeon.domain.repository.WeatherRepository
import com.jaehyeon.myapplication.presentation.usecases.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideWeatherUseCase(
        repository: WeatherRepository
    ): WeatherUseCase {
        return WeatherUseCase(repository)
    }

}