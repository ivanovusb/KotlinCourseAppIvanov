package com.example.kotlincourseappivanov.model

import android.widget.Toast
import com.example.kotlincourseappivanov.City
import com.example.kotlincourseappivanov.Weather

class WeatherRepositoryRemote: WeatherRepository {
    override fun getWeather(lat: Double, lon: Double): Weather {
        Thread {
            Thread.sleep(300L)
        }.start()
        return Weather(City("Владивосток", 1231.1231241, 1234.1241241), -40, +40)
    }

    override fun getListWeather(): List<Weather> {
        Thread {
            Thread.sleep(200L)
        }.start()
        return listOf(Weather(City("Владивосток", 1231.1231241, 1234.1241241), -40, +40))
    }
}