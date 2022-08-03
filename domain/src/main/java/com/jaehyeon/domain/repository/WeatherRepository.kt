package com.jaehyeon.domain.repository

import com.jaehyeon.domain.model.DomainWeather

/**
 * Created by Jaehyeon on 2022/08/03.
 */
interface WeatherRepository {

    suspend fun getWeatherData(data: HashMap<String, String>): DomainWeather
}