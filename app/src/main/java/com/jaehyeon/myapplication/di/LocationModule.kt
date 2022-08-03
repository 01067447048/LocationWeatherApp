package com.jaehyeon.myapplication.di

import com.jaehyeon.data.location.LocationRepositoryImpl
import com.jaehyeon.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 * Created by Jaehyeon on 2022/08/03.
 */
@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindLocationRepository(tracker: LocationRepositoryImpl): LocationRepository
}