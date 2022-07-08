package com.example.kotlincourseappivanov

data class Weather (val city: City = getDefaultCity(), val temperature: Int, val feelsLike: Int)

data class City (val name: String, val lat: Double, val lon: Double)

fun getDefaultCity() = City("Москва", 43.3372, 131.4118)