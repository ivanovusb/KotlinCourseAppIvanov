package com.example.kotlincourseappivanov.model

import com.example.kotlincourseappivanov.Weather

interface WeatherRepository {
    fun getWeather(lat: Double, lon: Double): Weather
    fun getListWeather(): List<Weather>
}