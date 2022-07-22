package com.example.kotlincourseappivanov.view

import com.example.kotlincourseappivanov.Weather

interface OnResponse {
    fun onResponse(weather: Weather)
}