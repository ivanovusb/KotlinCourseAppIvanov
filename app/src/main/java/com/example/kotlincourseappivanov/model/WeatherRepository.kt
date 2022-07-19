package com.example.kotlincourseappivanov.model

import com.example.kotlincourseappivanov.Weather

fun interface RepositorySingle {
    fun getWeather(lat: Double, lon: Double): Weather
}

fun interface RepositoryMulti {
    fun getListWeather(location: Location): List<Weather>
}

sealed class Location{
    object Russia: Location()
    object World: Location()
}