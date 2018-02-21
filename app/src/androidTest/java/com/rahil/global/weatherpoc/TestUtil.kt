package com.rahil.global.weatherpoc

import com.rahil.global.weatherpoc.data.local.WeatherEntity

import java.util.ArrayList

object TestUtil {

    fun createEntity(): List<WeatherEntity> {
        var list : ArrayList<WeatherEntity> = ArrayList()
        val entity = WeatherEntity()
        entity.sunrise = "6:00 am"
        entity.sunset = "6:00 pm"
        entity.info ="Sunny day"
        entity.date = "20 Feb 2018"
        entity.id ="20"
        list.add(entity)

        return list


    }

}
