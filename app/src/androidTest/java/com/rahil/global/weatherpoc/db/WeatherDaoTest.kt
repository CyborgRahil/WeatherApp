/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rahil.global.weatherpoc.db


import android.support.test.runner.AndroidJUnit4


import org.junit.Test
import org.junit.runner.RunWith


import com.rahil.global.weatherpoc.TestUtil
import com.rahil.global.weatherpoc.data.local.WeatherEntity
import io.reactivex.functions.Consumer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import java.util.ArrayList

@RunWith(AndroidJUnit4::class)
class WeatherDaoTest : DbTest() {

    @Test
    @Throws(InterruptedException::class)
    fun insertAndRead() {
        val repo = TestUtil.createEntity()
        db.getWeatherDao().insertForecast(repo)
        var list: List<WeatherEntity> = ArrayList<WeatherEntity>()

        db.getWeatherDao().getForeCast().subscribe(Consumer { list = it })
        assertThat(list, notNullValue())
        assertThat(list.get(0).date, `is`("20 Feb 2018"))
        assertThat(list.get(0).sunrise, `is`("6:00 am"))
        assertThat(list.get(0).sunset, `is`("6:00 pm"))
        assertThat(list.get(0).info, `is`("Sunny day"))
    }

}
