package com.jaehyeon.myapplication.presentation.ui.binding

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jaehyeon.myapplication.R
import com.jaehyeon.myapplication.presentation.model.WeatherModel
import com.jaehyeon.myapplication.utils.enums.RainType
import com.jaehyeon.myapplication.utils.enums.WindType

@SuppressLint("SetTextI18n")
@BindingAdapter("setTemp")
fun bindSetTemp(tv: TextView, model: WeatherModel?) {
    model ?: return

    tv.text = model.temperatures + "℃"
}

@BindingAdapter("setRain")
fun bindSetRain(tv: TextView, model: WeatherModel?) {
    model ?: return

    tv.text = when(model.rainType) {
        RainType.None -> {
            tv.context.getString(R.string.rain_type_none) + " (${model.rn1} mm)"
        }

        RainType.Rain -> {
            tv.context.getString(R.string.rain_type_rain) + " (${model.rn1} mm)"
        }

        RainType.RainOrSnow -> {
            tv.context.getString(R.string.rain_type_rain_or_snow) + " (${model.rn1} mm)"
        }

        RainType.Snow -> {
            tv.context.getString(R.string.rain_type_snow) + " (${model.rn1} mm)"
        }

        RainType.RainDrop -> {
            tv.context.getString(R.string.rain_type_raindrop) + " (${model.rn1} mm)"
        }

        RainType.RainDropAndSnow -> {
            tv.context.getString(R.string.rain_type_raindrop_and_snow) + " (${model.rn1} mm)"
        }

        RainType.SnowWind -> {
            tv.context.getString(R.string.rain_type_snow_wind) + " (${model.rn1} mm)"
        }
    }
}

@BindingAdapter("setWind")
fun bindSetWind(tv: TextView, model: WeatherModel?) {
    model ?: return

    tv.text = when(model.windType) {
        WindType.EastNorth -> {
            tv.context.getString(R.string.east_north) + " ${model.windSpeed} (${model.windDirection} deg)"
        }
        WindType.EastSouth -> {
            tv.context.getString(R.string.east_south) + " ${model.windSpeed} (${model.windDirection} deg)"
        }
        WindType.WestNorth -> {
            tv.context.getString(R.string.west_north) + " ${model.windSpeed} (${model.windDirection} deg)"
        }
        WindType.WestSouth -> {
            tv.context.getString(R.string.west_south) + " ${model.windSpeed} (${model.windDirection} deg)"
        }
    }
}

@BindingAdapter("setTime")
fun bindSetTime(tv: TextView, model: WeatherModel?) {
    model ?: return

    tv.text = String.format(tv.context.getString(R.string.now_time), model.now)
}
