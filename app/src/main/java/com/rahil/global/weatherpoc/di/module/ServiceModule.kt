package com.rahil.global.weatherpoc.di.module

import com.rahil.global.weatherpoc.data.remote.restApi.WeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Rahil on 19/2/18.
 */


@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideForecastService(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

}
