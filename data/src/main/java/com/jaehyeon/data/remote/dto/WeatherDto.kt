package com.jaehyeon.data.remote.dto

import android.util.Log
import com.jaehyeon.domain.model.DomainWeather

data class WeatherDto(
    val response: Response
)

fun WeatherDto.toDomainWeather(): DomainWeather {
    val temp = response.body.items.item.filter { it.category == "T1H" }.map { it.obsrValue }.first()
    val rn1 = response.body.items.item.filter { it.category == "RN1" }.map { it.obsrValue }.first()
    val eastWestWind = response.body.items.item.filter { it.category == "UUU" }.map { it.obsrValue }.first()
    val southNorthWind = response.body.items.item.filter { it.category == "VVV" }.map { it.obsrValue }.first()
    val humidity = response.body.items.item.filter { it.category == "REH" }.map { it.obsrValue }.first()
    val rainType = response.body.items.item.filter { it.category == "PTY" }.map { it.obsrValue }.first()
    val windDirection = response.body.items.item.filter { it.category == "VEC" }.map { it.obsrValue }.first()
    val windSpeed = response.body.items.item.filter { it.category == "WSD" }.map { it.obsrValue }.first()

    return DomainWeather(
        temp, rn1, eastWestWind, southNorthWind, humidity, rainType, windDirection, windSpeed
    )
}