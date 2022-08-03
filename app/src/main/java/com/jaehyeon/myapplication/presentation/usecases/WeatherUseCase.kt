package com.jaehyeon.myapplication.presentation.usecases

import com.jaehyeon.data.exception.WeatherApiException
import com.jaehyeon.domain.repository.WeatherRepository
import com.jaehyeon.myapplication.presentation.model.WeatherModel
import com.jaehyeon.myapplication.presentation.model.toWeatherModel
import com.jaehyeon.myapplication.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/08/03.
 */
class WeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
){
    suspend fun invoke(data: HashMap<String, String>): Flow<Resource<WeatherModel>> = flow {
        try {
            val weatherModel = repository.getWeatherData(data).toWeatherModel()
            emit(Resource.Success<WeatherModel>(weatherModel))
        } catch (t: WeatherApiException) {
            emit(Resource.Error<WeatherModel>(t.message ?: ""))
        } catch (t: Throwable) {
            emit(Resource.Error<WeatherModel>(t.message ?: ""))
        }
    }
}