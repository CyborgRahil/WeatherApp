package com.rahil.global.weatherpoc.weather.domain.model

data class Channel(val atmosphere: Atmosphere,
                   val image: Image,
                   val item: Item,
                   val lastBuildDate: String = "",
                   val link: String = "",
                   val description: String = "",
                   val language: String = "",
                   val units: Units,
                   val title: String = "",
                   val astronomy: Astronomy,
                   val ttl: String = "",
                   val location: Location,
                   val wind: Wind)