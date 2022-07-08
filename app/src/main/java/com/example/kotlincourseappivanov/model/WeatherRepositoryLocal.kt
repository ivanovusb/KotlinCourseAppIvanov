package com.example.kotlincourseappivanov.model

import com.example.kotlincourseappivanov.City
import com.example.kotlincourseappivanov.Weather
import com.example.kotlincourseappivanov.getDefaultCity

class WeatherRepositoryLocal:WeatherRepository {
    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather(getDefaultCity(), -20, +20)
    }

    override fun getListWeather(): List<Weather> {
        return listOf(Weather(getDefaultCity(), -20, +20))
    }
}