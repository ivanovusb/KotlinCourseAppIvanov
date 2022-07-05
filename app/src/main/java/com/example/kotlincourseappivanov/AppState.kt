package com.example.kotlincourseappivanov

sealed class AppState {
    data class Success(val weatherData: Weather): AppState()
    data class Error(val weatherData: Throwable): AppState()
    object Loading: AppState()
}