package com.example.kotlincourseappivanov.model

import com.example.kotlincourseappivanov.Weather

fun interface RepositorySingle {
    fun getWeather()
}

fun interface RepositoryMulti {
    fun getListWeather(): List<Weather>
}

sealed class Location{
    object Russia: Location()
    object World: Location()
}