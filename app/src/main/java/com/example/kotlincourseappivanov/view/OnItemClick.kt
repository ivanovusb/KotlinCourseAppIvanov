package com.example.kotlincourseappivanov.view

import com.example.kotlincourseappivanov.Weather

fun interface OnItemClick {
    fun onItemClick(weather: Weather)
}