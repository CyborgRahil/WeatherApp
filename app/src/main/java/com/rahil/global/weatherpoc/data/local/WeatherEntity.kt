package com.rahil.global.weatherpoc.data.local

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey


/**
 * Created by global on 19/2/18.
 */

@Entity(tableName = "ForeCastTable")
class WeatherEntity {

    var id: String = ""
    @PrimaryKey
    @ColumnInfo(name = "date")
    var date: String = ""

    @ColumnInfo(name = "info")
    var info: String? = null

    @ColumnInfo(name = "sunset")
    var sunset: String? = null

    @ColumnInfo(name = "sunrise")
    var sunrise: String? = null

    @ColumnInfo(name = "high_temperature")
    var highTemp: String? = null


    @ColumnInfo(name = "low_temperature")
    var lowTemp: String? = null
}

