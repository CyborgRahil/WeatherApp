package com.rahil.global.weatherpoc.forecast.view

import com.rahil.global.weatherpoc.data.WeatherDataRepository
import com.rahil.global.weatherpoc.weather.domain.usecase.GetWeatherReportUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Rahil on 19/2/18.
 */
class HomePresenter
@Inject constructor(private val weatherReportUseCase: GetWeatherReportUseCase, private val repository: WeatherDataRepository) : HomeContract.Presenter {

    lateinit var mView: HomeContract.WeatherView
    val mDisposable: CompositeDisposable = CompositeDisposable()

    /**
     * This method binds presenter with a view.
     */
    override fun takeView(view: HomeContract.WeatherView) {
        mView = view
    }


    override fun dropView() {
        if (mDisposable != null) {
            mDisposable.dispose()
        }
    }


    /***
     * This method is use to get list of forecast from API
     *
     */
    override fun getWeatherList() {
        mDisposable.add(weatherReportUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    mView.hideProgressBar()
                    mView.showErrorMessage()
                }
                .subscribe({
                    mView.hideProgressBar()
                    if (it.isEmpty()) {
                        mView.showErrorMessage()
                    }
                    mView.setupRecyclerViewAdapter(it)
                }))


    }


}