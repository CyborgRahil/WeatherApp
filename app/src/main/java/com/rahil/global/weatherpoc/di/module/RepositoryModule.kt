package com.rahil.global.weatherpoc.di.module

import android.content.Context

import com.rahil.global.weatherpoc.data.WeatherDataRepository
import com.rahil.global.weatherpoc.data.WeatherDataRepositoryImpl
import com.rahil.global.weatherpoc.data.local.WeatherDao
import com.rahil.global.weatherpoc.data.remote.restApi.WeatherApi

import javax.inject.Named

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rahil on 19/2/18.
 */

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherDataRepository(service: WeatherApi, weatherDao: WeatherDao): WeatherDataRepository {
        return WeatherDataRepositoryImpl(service, weatherDao)
    }

}
