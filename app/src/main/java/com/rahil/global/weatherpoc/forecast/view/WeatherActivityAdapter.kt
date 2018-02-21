package com.rahil.global.weatherpoc.forecast.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rahil.global.weatherpoc.R
import com.rahil.global.weatherpoc.data.local.WeatherEntity
import kotlinx.android.synthetic.main.item_weather_list.view.*

/**
 * Created by Rahil on 19/2/18.
 */
class WeatherActivityAdapter(private val weekForeCast: List<WeatherEntity>) : RecyclerView.Adapter<WeatherListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherListViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_weather_list, parent, false)
        return WeatherListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return weekForeCast.size

    }

    override fun onBindViewHolder(holder: WeatherListViewHolder?, position: Int) {
        holder?.bindForecast(weekForeCast.get(position))
    }

}

class WeatherListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /**
     * This method is use to bind data to adapter.
     *
     */
    fun bindForecast(forecast: WeatherEntity) {
        with(forecast) {
            itemView.tv_date.text = forecast.date
            itemView.tv_text.text = forecast.info
            itemView.tv_high_temp.text = forecast.highTemp
            itemView.tv_low_temp.text = forecast.lowTemp
            itemView.tv_sunrise.text = forecast.sunrise
            itemView.tv_sunset.text = forecast.sunset

        }
    }

}



