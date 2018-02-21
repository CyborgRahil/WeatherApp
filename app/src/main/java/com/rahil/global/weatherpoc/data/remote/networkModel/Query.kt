package com.rahil.global.weatherpoc.weather.domain.model

data class Query(val created: String = "",
                 val count: Int = 0,
                 val lang: String = "",
                 val results: Results)