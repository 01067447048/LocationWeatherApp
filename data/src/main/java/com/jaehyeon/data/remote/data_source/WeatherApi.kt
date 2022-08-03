package com.jaehyeon.data.remote.data_source

import com.jaehyeon.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Jaehyeon on 2022/08/03.
 */
interface WeatherApi {
    /**
     * ServiceKey
     * pageNo
     * numOfRows
     * dataType
     * base_date
     * base_time
     * nx
     * ny
     */
    @GET("1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")
    suspend fun getWeatherData(@QueryMap data: HashMap<String, String>): WeatherDto
}