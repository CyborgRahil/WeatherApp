package com.rahil.global.weatherpoc.di.module

import dagger.Provides
import javax.inject.Singleton
import android.arch.persistence.room.Room
import android.app.Application
import com.rahil.global.weatherpoc.data.local.WeatherDao
import com.rahil.global.weatherpoc.data.local.WeatherRoom
import dagger.Module


/**
 * Created by Rahil on 20/2/18.
 */

@Module
class RoomModule(mApplication: Application) {

    private val roomDatabase: WeatherRoom

    init {
        roomDatabase = Room.databaseBuilder(mApplication, WeatherRoom::class.java!!, "WeatherPoc.db").build()
    }

    @Singleton
    @Provides
    fun providesWeatherRoom(): WeatherRoom {
        return roomDatabase
    }

    @Singleton
    @Provides
    fun providesWeatherDao(roomDataBase: WeatherRoom): WeatherDao {
        return roomDatabase.getWeatherDao()
    }


}