package com.example.kotlincourseappivanov.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincourseappivanov.Weather
import com.example.kotlincourseappivanov.databinding.WeatherFragmentDetailsBinding
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = (arguments?.getParcelable<Weather>(BUNDLE_WEATHER_EXTRA))
        if (weather != null)
            renderData(weather)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun renderData(weather: Weather) {
        binding.cityName.text = weather.city.name
        binding.temperatureValue.text = weather.temperature.toString()
        binding.feelsLikeValue.text = weather.feelsLike.toString()
        binding.cityCoordinates.text = "${weather.city.lat} / ${weather.city.lon}"
    }

    companion object {
        const val BUNDLE_WEATHER_EXTRA = "asnqwrwqr"
        fun newInstance(weather: Weather): WeatherFragmentDetails {
            val bundle = Bundle()
            bundle.putParcelable(BUNDLE_WEATHER_EXTRA, weather)
            WeatherFragmentList()
            val fr = WeatherFragmentDetails()
            fr.arguments = bundle
            return fr
        }
    }
}