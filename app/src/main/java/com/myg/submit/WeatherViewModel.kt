package com.myg.submit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONObject
import com.myg.submit.ForecastModel
import com.myg.submit.WeatherModel
import com.myg.submit.WeatherRepository

class WeatherViewModel : ViewModel() {
    private val TAG: String = WeatherViewModel::class.java.simpleName

    private val weatherRepository = WeatherRepository()

    val isSuccWeather = MutableLiveData<Boolean>()
    val isSuccForecast = MutableLiveData<Boolean>()
    val responseWeather = MutableLiveData<WeatherModel>()
    val responseForecast = MutableLiveData<ForecastModel>()


    fun getWeatherInfoView(jsonObject: JSONObject) {
        Log.d(TAG, "getWeatherInfoView() - jsonObject : " + jsonObject);

        weatherRepository.getWeatherInfo(jsonObject = jsonObject,
            onResponse = {
                if (it.isSuccessful) {
                    Log.d(TAG, "getWeatherInfoView() - Succ : " + it.body());
                    isSuccWeather.value = true
                    responseWeather.value = it.body()
                }
            },
            onFailure = {
                it.printStackTrace()
                Log.d(TAG, "getWeatherInfoView() - Fail : " + it.message);
            }
        )

    }


    fun getForecastInfoView(jsonObject: JSONObject) {
        Log.d(TAG, "getForecastInfoView() - jsonObject : " + jsonObject);

        weatherRepository.getForecastInfo(jsonObject = jsonObject,
            onResponse = {
                if (it.isSuccessful) {
                    isSuccForecast.value = true
                    Log.d(TAG, "getForecastInfoView() - Succ : " + it.body());
                    responseForecast.value = it.body()
                }
            },
            onFailure = {
                it.printStackTrace()
                Log.d(TAG, "getForecastInfoView() - Fail : " + it.message);
            }
        )

    }
}