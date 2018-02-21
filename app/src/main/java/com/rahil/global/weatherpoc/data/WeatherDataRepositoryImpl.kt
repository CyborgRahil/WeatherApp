package com.rahil.global.weatherpoc.data

import android.util.Log
import com.rahil.global.weatherpoc.data.local.WeatherDao
import com.rahil.global.weatherpoc.data.local.WeatherEntity
import com.rahil.global.weatherpoc.data.remote.restApi.WeatherApi
import com.rahil.global.weatherpoc.utility.Utility
import io.reactivex.Flowable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Rahil on 19/2/18.
 */
@Singleton
class WeatherDataRepositoryImpl
@Inject
constructor(private val service: WeatherApi, private val weather: WeatherDao) : WeatherDataRepository {

    /**
     * This method use to store data in Room database.
     *
     */
    override fun storeUsersInDb(forecastItem: List<WeatherEntity>) {
        weather.insertForecast(forecastItem)
    }

    /**
     * This method use to fetch data from Room database.
     *
     */
    override fun getForeCastDataFromDb(): Flowable<List<WeatherEntity>> {
        return weather.getForeCast()
                .doOnNext(Consumer { Log.e("size", it.size.toString()) })
                .onErrorReturn { t: Throwable -> emptyList() }


    }

    /**
     * This method use to fetch data from server.
     *
     */
    override fun getWeatherData(): Flowable<List<WeatherEntity>> {

        val forecast = service
                .getForecast()

        return forecast
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map {
                    Utility.convertIntoWeatherModel(it)
                }
                // Add data to Room for caching purpose
                .doOnNext({ storeUsersInDb(it) })
                // Get data from data base when api call is failed due to any reason.
                .onErrorResumeNext(getForeCastDataFromDb())
                .onErrorReturn { t: Throwable -> emptyList() }


    }
}