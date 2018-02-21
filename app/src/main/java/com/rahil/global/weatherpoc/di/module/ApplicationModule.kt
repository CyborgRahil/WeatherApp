package com.rahil.global.weatherpoc.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.rahil.global.weatherpoc.WeatherApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rahil on 19/2/18.
 */


@Module
class ApplicationModule(private val mainApplication: WeatherApp) {

    @Provides
    @Singleton
    internal fun provideMainApplication(): WeatherApp {
        return mainApplication
    }

    @Provides
    @Singleton
    internal fun provideSharedPreferences(mainApplication: WeatherApp): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(mainApplication)
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return mainApplication
    }

}
