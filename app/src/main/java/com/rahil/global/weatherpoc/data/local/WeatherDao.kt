package com.rahil.global.weatherpoc.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable


/**
 * Created by Rahil on 19/2/18.
 */


@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertForecast(forecastItems: List<WeatherEntity>)

    @Query("SELECT * FROM ForeCastTable")
    fun getForeCast(): Flowable<List<WeatherEntity>>
}