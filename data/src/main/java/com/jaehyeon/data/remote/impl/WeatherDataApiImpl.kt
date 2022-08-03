package com.jaehyeon.data.remote.impl

import com.jaehyeon.data.remote.data_source.WeatherApi
import com.jaehyeon.data.remote.dto.WeatherDto
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/08/03.
 */
class WeatherDataApiImpl @Inject constructor(
    private val retrofit: Retrofit
): WeatherApi{

    override suspend fun getWeatherData(data: HashMap<String, String>): WeatherDto {
        return retrofit.create(WeatherApi::class.java).getWeatherData(data)
    }

}