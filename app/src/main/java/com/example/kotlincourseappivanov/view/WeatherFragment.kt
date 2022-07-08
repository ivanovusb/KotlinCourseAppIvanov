package com.example.kotlincourseappivanov.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincourseappivanov.databinding.WeatherFragmentBinding
import com.example.kotlincourseappivanov.viewmodel.AppState
import com.example.kotlincourseappivanov.viewmodel.WeatherViewModel

class WeatherFragment: Fragment() {

    companion object {
        fun newInstance() = WeatherFragment()
    }

    private lateinit var binding: WeatherFragmentBinding
    private lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WeatherFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                renderData(t)
            }
        })
        viewModel.sentRequest()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {
                binding.cityName.text = "Ошибка загрузки данных"
                binding.temperatureValue.text = "Ошибка загрузки данных"
                binding.feelsLikeValue.text = "Ошибка загрузки данных"
                binding.cityCoordinates.text = "Ошибка загрузки данных"
            }
            AppState.Loading -> {
                binding.cityName.text = "Загрузка..."
                binding.temperatureValue.text = "Загрузка..."
                binding.feelsLikeValue.text = "Загрузка..."
                binding.cityCoordinates.text = "Загрузка..."
            }
            is AppState.Success -> {
                val result = appState.weatherData
                binding.cityName.text = result.city.name
                binding.temperatureValue.text = result.temperature.toString()
                binding.feelsLikeValue.text = result.feelsLike.toString()
                binding.cityCoordinates.text = "${result.city.lat} / ${result.city.lon}"
            }
        }
    }



}