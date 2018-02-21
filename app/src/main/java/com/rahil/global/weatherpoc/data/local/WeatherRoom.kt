package com.rahil.global.weatherpoc.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


/**
 * Created by Rahil on 19/2/18.
 */


@Database(entities = arrayOf(WeatherEntity::class), version = 1)
abstract class WeatherRoom : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDao

}

