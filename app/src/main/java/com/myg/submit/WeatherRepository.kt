package com.myg.submit

import com.myg.submit.ForecastModel
import com.myg.submit.WeatherModel
import com.myg.submit.RemoteDataSource
import com.myg.submit.RemoteDataSourcelmpl
import org.json.JSONObject
import retrofit2.Response

class WeatherRepository {
    private val retrofitRemoteDataSource: RemoteDataSource = RemoteDataSourcelmpl()
    fun getWeatherInfo(
        jsonObject: JSONObject,
        onResponse: (Response<WeatherModel>) -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        retrofitRemoteDataSource.getWeatherInfo(jsonObject, onResponse, onFailure)
    }

    fun getForecastInfo(
        jsonObject: JSONObject,
        onResponse: (Response<ForecastModel>) -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        retrofitRemoteDataSource.getForecastInfo(jsonObject, onResponse, onFailure)
    }
}