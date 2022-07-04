package com.example.kotlincourseappivanov.model

import com.example.kotlincourseappivanov.Weather

class WeatherRepositoryRemote: WeatherRepository {
    override fun getWeather(lat: Double, lon: Double): Weather {
        TODO("Not yet implemented")
    }

    override fun getListWeather(): List<Weather> {
        TODO("Not yet implemented")
    }
}