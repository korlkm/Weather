package com.myg.submit

import com.google.gson.annotations.SerializedName

data class ForecastModel(
    @SerializedName("cod")
    var cod: String?,

    @SerializedName("cnt")
    var cnt: Int?,

    @SerializedName("list")
    var list: List<ForecastListModel>?,
)

data class ForecastListModel(
    @SerializedName("dt_txt")
    var dt_txt: String?, // 2023-03-04 15::00::00

    @SerializedName("main")
    var main: WeatherMainModel?,

    @SerializedName("weather")
    var weather: List<WeatherWeatherModel>?,
)
