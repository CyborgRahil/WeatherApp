package com.rahil.global.weatherpoc

import android.app.Application
import android.util.Log
import com.rahil.global.weatherpoc.base.BaseActivity
import com.rahil.global.weatherpoc.di.component.ActivityComponent
import com.rahil.global.weatherpoc.di.component.ApplicationComponent
import com.rahil.global.weatherpoc.di.component.DaggerActivityComponent
import com.rahil.global.weatherpoc.di.component.DaggerApplicationComponent
import com.rahil.global.weatherpoc.di.module.ActivityModule
import com.rahil.global.weatherpoc.di.module.ApplicationModule
import com.rahil.global.weatherpoc.di.module.NetworkModule
import com.rahil.global.weatherpoc.di.module.RoomModule
import com.rahil.global.weatherpoc.utility.WeatherAppConstants
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.exceptions.UndeliverableException

import io.reactivex.plugins.RxJavaPlugins


/**
 * Created by global on 19/2/18.
 */
class WeatherApp : Application() {


    private var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        init()
        setupRxErrorHandler()
    }

    private fun init() {
        initDagger()
    }

    /**
     * Initialize dagger for Application Module and create ApplicationComponent instance
     *
     */
    private fun initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule(WeatherAppConstants.API_URL))
                .roomModule(RoomModule(this))
                .build()
    }

    /**
     * Create instance of Activity component.
     *
     */
    fun createActivityComponent(activity: BaseActivity): ActivityComponent {
        return DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(activity))
                .build()
    }

    fun getDiComponent(): ApplicationComponent? {
        return applicationComponent
    }

    /**
     * Handle unknown Exception of Rx Java
     *
     */
    fun setupRxErrorHandler() {
        if (!BuildConfig.DEBUG) {
            RxJavaPlugins.setErrorHandler { throwable ->
                if (throwable is OnErrorNotImplementedException) {
                    Thread.getDefaultUncaughtExceptionHandler()
                            .uncaughtException(Thread.currentThread(), throwable)
                } else if (throwable is UndeliverableException) {
                    Log.e("exception", throwable.toString())
                } else {
                    Log.e("exception", throwable.toString())
                }
                Log.e("exception", throwable.toString())
            }
        }
    }
}
