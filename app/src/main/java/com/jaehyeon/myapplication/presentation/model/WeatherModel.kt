package com.jaehyeon.myapplication.presentation.model

import com.jaehyeon.domain.model.DomainWeather
import com.jaehyeon.myapplication.utils.enums.RainType
import com.jaehyeon.myapplication.utils.enums.WindType
import java.time.LocalDateTime

data class WeatherModel(
    val temperatures: String,
    val rn1: String,
    val windType: WindType,
    val humidity: String,
    val rainType: RainType,
    val windDirection: String,
    val windSpeed: String,
    val now: String
)

fun DomainWeather.toWeatherModel(): WeatherModel {

    val windType = when {
        eastWestWind.toFloat() > 0 && southNorthWind.toFloat() > 0 -> {
            WindType.EastNorth
        }
        eastWestWind.toFloat() > 0 && southNorthWind.toFloat() < 0 -> {
            WindType.EastSouth
        }
        eastWestWind.toFloat() < 0 && southNorthWind.toFloat() > 0 -> {
            WindType.WestNorth
        }
        else -> {
            WindType.WestSouth
        }
    }

    val rainType = when(rainType) {
        "1" -> RainType.Rain
        "2" -> RainType.RainOrSnow
        "3" -> RainType.Snow
        "5" -> RainType.RainDrop
        "6" -> RainType.RainDropAndSnow
        "7" -> RainType.SnowWind
        else -> RainType.None
    }

    val now = LocalDateTime.now()

    val time = if (now.minute < 30) {
        if (now.hour > 9)
            "${now.hour}:00"
        else
            "0${now.hour}:00"
    } else {
        if (now.hour + 1 > 9) {
            "${now.hour + 1}:00"
        }
        else {
            "0${now.hour + 1}:00"
        }
    }

    return WeatherModel(
        temperatures = temperatures,
        rn1 = rn1,
        windType = windType,
        humidity = humidity,
        rainType = rainType,
        windDirection = windDirection,
        windSpeed = windSpeed,
        now = time
    )
}
