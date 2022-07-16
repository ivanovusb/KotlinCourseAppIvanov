package com.example.kotlincourseappivanov.viewmodel

import com.example.kotlincourseappivanov.Weather

sealed class AppState {
    data class SuccessSingle(val weatherData: Weather): AppState()
    data class SuccessMulti(val weatherData: List<Weather>): AppState()
    data class Error(val weatherData: Throwable): AppState()
    object Loading: AppState()
}