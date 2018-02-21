package com.rahil.global.weatherpoc.di.component

import com.rahil.global.weatherpoc.di.ActivityScope
import com.rahil.global.weatherpoc.di.module.ActivityModule
import com.rahil.global.weatherpoc.forecast.domain.view.HomeActivity
import com.rahil.global.weatherpoc.weather.domain.usecase.GetWeatherReportUseCase
import dagger.Component

/**
 * Created by Rahil on 19/2/18.
 */

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))

interface ActivityComponent {

    fun inject(activity: HomeActivity)

    fun getWeatherReportUseCase(): GetWeatherReportUseCase

}