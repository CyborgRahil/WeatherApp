

package com.rahil.global.weatherpoc.db


import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry

import com.rahil.global.weatherpoc.data.local.WeatherRoom

import org.junit.After
import org.junit.Before

abstract class DbTest {
    protected lateinit var db: WeatherRoom

    @Before
    fun initDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                WeatherRoom::class.java).build()
    }

    @After
    fun closeDb() {
        db.close()
    }
}
