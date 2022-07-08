package com.example.kotlincourseappivanov.viewmodel

import com.example.kotlincourseappivanov.Weather

sealed class AppState {
    data class Success(val weatherData: Weather): AppState()
    data class Error(val weatherData: Throwable): AppState()
    object Loading: AppState()
}