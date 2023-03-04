package com.myg.submit

import com.myg.submit.ForecastModel
import com.myg.submit.WeatherModel
import org.json.JSONObject
import retrofit2.Response

interface RemoteDataSource {

    fun getWeatherInfo(
        jsonObject: JSONObject,
        onResponse: (Response<WeatherModel>) -> Unit,
        onFailure: (Throwable) -> Unit
    )

    fun getForecastInfo(
        jsonObject: JSONObject,
        onResponse: (Response<ForecastModel>) -> Unit,
        onFailure: (Throwable) -> Unit
    )
}