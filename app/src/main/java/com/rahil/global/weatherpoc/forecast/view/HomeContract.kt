package com.rahil.global.weatherpoc.forecast.view

import com.rahil.global.weatherpoc.base.BasePresenter
import com.rahil.global.weatherpoc.base.BaseView
import com.rahil.global.weatherpoc.data.local.WeatherEntity

/**
 * Created by Rahil on 19/2/18.
 */
interface HomeContract {

    interface WeatherView : BaseView<Presenter> {
        fun showProgressBar()
        fun hideProgressBar()
        fun showErrorMessage()
        fun setupRecyclerViewAdapter(weatherList: List<WeatherEntity>)
    }

    interface Presenter : BasePresenter<WeatherView> {

        fun getWeatherList()

    }

}