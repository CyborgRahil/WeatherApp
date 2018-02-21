package com.rahil.global.weatherpoc.di.component

import com.rahil.global.weatherpoc.WeatherApp
import com.rahil.global.weatherpoc.data.WeatherDataRepository
import com.rahil.global.weatherpoc.data.local.WeatherDao
import com.rahil.global.weatherpoc.data.remote.restApi.WeatherApi
import com.rahil.global.weatherpoc.di.ApplicationScope
import com.rahil.global.weatherpoc.di.module.*
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Rahil on 19/2/18.
 */
@Singleton
@ApplicationScope
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class, ServiceModule::class, RepositoryModule::class, RoomModule::class))
interface ApplicationComponent {

    fun weatherApp(): WeatherApp

    fun weatherDataRepository(): WeatherDataRepository

    fun weatherApi(): WeatherApi

    fun weatherDao(): WeatherDao


}
