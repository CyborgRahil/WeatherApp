package com.rahil.global.weatherpoc.data.remote.restApi

import com.rahil.global.weatherpoc.weather.domain.model.Weather
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by Rahil on 19/2/18.
 */


public interface WeatherApi {

    @GET("v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"bangalore\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    fun getForecast(): Flowable<Weather>
}