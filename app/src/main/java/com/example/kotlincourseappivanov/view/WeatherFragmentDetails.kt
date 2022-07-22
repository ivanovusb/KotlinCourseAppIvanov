package com.example.kotlincourseappivanov.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincourseappivanov.Weather
import com.example.kotlincourseappivanov.databinding.WeatherFragmentDetailsBinding
import com.example.kotlincourseappivanov.model.dto.WeatherDTO
import com.example.kotlincourseappivanov.utils.WeatherLoader
import com.example.kotlincourseappivanov.viewmodel.AppState
import com.example.kotlincourseappivanov.viewmodel.WeatherViewModel

class WeatherFragmentDetails : Fragment() {


    private var _binding: WeatherFragmentDetailsBinding? = null
    private val binding: WeatherFragmentDetailsBinding
        get() {
            return _binding!!
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WeatherFragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = arguments?.let { arg ->
            arg.getParcelable<Weather>(BUNDLE_WEATHER_EXTRA)
        }

        weather?.let { weatherLocal ->
            WeatherLoader.requestWeather(
                weatherLocal.city.lat,
                weatherLocal.city.lon
            ) {weatherDTO ->
                bindWeatherLocalWithWeatherDTO(weatherLocal, weatherDTO)
            }
        }
    }

    private fun bindWeatherLocalWithWeatherDTO(
        weatherLocal: Weather,
        weatherDTO: WeatherDTO
    ) {
        requireActivity().runOnUiThread {
            renderData(weatherLocal.apply {
                weatherLocal.feelsLike = weatherDTO.fact.feelsLike
                weatherLocal.temperature = weatherDTO.fact.temp
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun renderData(weather: Weather) {
        with(binding) {
            cityName.text = weather.city.name
            temperatureValue.text = weather.temperature.toString()
            feelsLikeValue.text = weather.feelsLike.toString()
            cityCoordinates.text = "${weather.city.lat} / ${weather.city.lon}"
        }
    }

    companion object {
        const val BUNDLE_WEATHER_EXTRA = "asnqwrwqr"
        fun newInstance(weather: Weather) = WeatherFragmentDetails().apply {
            arguments = Bundle().apply { putParcelable(BUNDLE_WEATHER_EXTRA, weather) }
        }
    }
}