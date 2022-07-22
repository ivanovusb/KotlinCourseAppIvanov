package com.example.kotlincourseappivanov.model

import com.example.kotlincourseappivanov.*

class WeatherRepositoryLocal : RepositorySingle, RepositoryMulti {
    override fun getListWeather(location: Location): List<Weather> {
        return when (location) {
            Location.Russia -> {
                getRussianCities()
            }
            Location.World -> {
                getWorldCities()
            }
        }
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}
