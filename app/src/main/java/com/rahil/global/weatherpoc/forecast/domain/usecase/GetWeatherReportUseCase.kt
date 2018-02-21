package com.rahil.global.weatherpoc.weather.domain.usecase

import com.rahil.global.weatherpoc.data.WeatherDataRepository
import com.rahil.global.weatherpoc.data.local.WeatherEntity
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Rahil on 19/2/18.
 */
interface GetWeatherReportUseCase {

    fun execute(): Flowable<List<WeatherEntity>>

}

class GetWeatherReportUseCaseImpl
@Inject
constructor(private val repository: WeatherDataRepository) : GetWeatherReportUseCase {

    /***
     * This method is use to execute the task of usecase
     *
     */
    override fun execute(): Flowable<List<WeatherEntity>> {
        return repository.getWeatherData()
    }

}