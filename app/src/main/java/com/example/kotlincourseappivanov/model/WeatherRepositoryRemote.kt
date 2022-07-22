package com.example.kotlincourseappivanov.model

import android.widget.Toast
import com.example.kotlincourseappivanov.City
import com.example.kotlincourseappivanov.Weather

class WeatherRepositoryRemote : RepositorySingle {
    override fun getWeather(lat: Double, lon: Double): Weather {
        Thread {
            Thread.sleep(30L)
        }.start()
        return Weather()
    }
}