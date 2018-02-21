package com.rahil.global.weatherpoc.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rahil.global.weatherpoc.WeatherApp
import com.rahil.global.weatherpoc.di.component.ActivityComponent

/**
 * Created by Rahil on 19/2/18.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * Creates and return the activity scoped component for dependency injection.
     *
     * @return Bali activity component for dependency injection.
     */
    var mActivityComponent: ActivityComponent? = null

    fun getBaliActivityComponent(): ActivityComponent {
        if (mActivityComponent == null) {
            mActivityComponent = getMainApplication().createActivityComponent(this)
        }
        return mActivityComponent as ActivityComponent
    }

    private fun getMainApplication(): WeatherApp {
        return application as WeatherApp
    }
}