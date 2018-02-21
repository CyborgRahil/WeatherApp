package com.rahil.global.weatherpoc.data

import com.rahil.global.weatherpoc.data.local.WeatherEntity
import io.reactivex.Flowable


/**
 * Created by Rahil on 19/2/18.
 */
interface WeatherDataRepository {

    fun getWeatherData(): Flowable<List<WeatherEntity>>

    fun getForeCastDataFromDb(): Flowable<List<WeatherEntity>>

    fun storeUsersInDb(users: List<WeatherEntity>)


}

