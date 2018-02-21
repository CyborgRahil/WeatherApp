package com.rahil.global.weatherpoc.utility

import com.rahil.global.weatherpoc.data.local.WeatherEntity
import com.rahil.global.weatherpoc.weather.domain.model.Weather
import java.util.ArrayList

/**
 * Created by global on 20/2/18.
 */
class Utility {

    companion object {
        /**
         * This method works is a model mapper to convert weather model into List<WeatherEntity>
         *
         */
        fun convertIntoWeatherModel(it: Weather?): List<WeatherEntity> {
            var list: ArrayList<WeatherEntity> = ArrayList<WeatherEntity>()
            var sunRise: String = it!!.query.results.channel.astronomy.sunrise
            var sunSet: String = it!!.query.results.channel.astronomy.sunset
            var unit: String = it!!.query.results.channel.units.temperature
            for (i in 0 until it!!.query.results.channel.item.forecast!!.size) {
                var weatherModel: WeatherEntity = WeatherEntity()
                weatherModel.date = it!!.query.results.channel.item.forecast!!.get(i).date
                weatherModel.highTemp = it!!.query.results.channel.item.forecast!!.get(i).high + " " + unit
                weatherModel.id = it!!.query.results.channel.item.forecast!!.get(i).code
                weatherModel.lowTemp = it!!.query.results.channel.item.forecast!!.get(i).low + " " + unit
                weatherModel.info = it!!.query.results.channel.item.forecast!!.get(i).text
                weatherModel.sunset = sunSet
                weatherModel.sunrise = sunRise
                list.add(weatherModel)

            }


            return list


        }

    }

}