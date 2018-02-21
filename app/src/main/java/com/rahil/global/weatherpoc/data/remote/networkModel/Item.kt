package com.rahil.global.weatherpoc.weather.domain.model

data class Item(val condition: Condition,
                val link: String = "",
                val description: String = "",
                val guid: Guid,
                val forecast: List<ForecastItem>?,
                val title: String = "",
                val pubDate: String = "",
                val lat: String = "",
                val long: String = "")