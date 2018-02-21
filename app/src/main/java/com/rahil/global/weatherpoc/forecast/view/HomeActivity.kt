package com.rahil.global.weatherpoc.forecast.domain.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.rahil.global.weatherpoc.R
import com.rahil.global.weatherpoc.base.BaseActivity
import com.rahil.global.weatherpoc.data.local.WeatherEntity
import com.rahil.global.weatherpoc.forecast.view.HomeContract
import com.rahil.global.weatherpoc.forecast.view.HomePresenter
import com.rahil.global.weatherpoc.forecast.view.WeatherActivityAdapter
import kotlinx.android.synthetic.main.activity_weather.*
import javax.inject.Inject

/**
 * Created by Rahil on 19/2/18.
 */
class HomeActivity : BaseActivity(), HomeContract.WeatherView {

    lateinit var mAdapter: WeatherActivityAdapter

    @Inject
    lateinit var mHomePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        getBaliActivityComponent().inject(this)
        initRecyclerView()
        mHomePresenter.getWeatherList()
    }

    private fun initRecyclerView() {
        weatherList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        weatherList.hasFixedSize()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        mHomePresenter.dropView()
    }

    override fun onStart() {
        super.onStart()
        mHomePresenter.takeView(this)

    }

    /**
     * show progressbar on Network call
     */
    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    /**
     * Hide progressbar after getting response from Network call
     */
    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    /**
     * show Error message
     */
    override fun showErrorMessage() {
        Toast.makeText(this, this.getString(R.string.network_error), Toast.LENGTH_SHORT).show()
    }

    /**
     * set up recycler view to show Forecast of weather
     */
    override fun setupRecyclerViewAdapter(weatherModel: List<WeatherEntity>) {
        mAdapter = WeatherActivityAdapter(weatherModel!!)
        weatherList.adapter = mAdapter
    }

}