package com.rahil.global.weatherpoc.di.module

import com.rahil.global.weatherpoc.base.BaseActivity
import com.rahil.global.weatherpoc.data.WeatherDataRepository
import com.rahil.global.weatherpoc.forecast.view.HomePresenter
import com.rahil.global.weatherpoc.weather.domain.usecase.GetWeatherReportUseCase
import com.rahil.global.weatherpoc.weather.domain.usecase.GetWeatherReportUseCaseImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Rahil on 19/2/18.
 */

@Module
class ActivityModule(private val baseActivity: BaseActivity) {

    @Provides
    internal fun provideHomePresenter(useCase: GetWeatherReportUseCase, repository: WeatherDataRepository): HomePresenter {
        return HomePresenter(useCase, repository)
    }

    @Provides
    internal fun provideGetWeatherReportUseCase(repository: WeatherDataRepository): GetWeatherReportUseCase {
        return GetWeatherReportUseCaseImpl(repository)
    }


}