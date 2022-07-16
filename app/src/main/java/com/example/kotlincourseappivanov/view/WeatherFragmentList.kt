package com.example.kotlincourseappivanov.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlincourseappivanov.Weather
import com.example.kotlincourseappivanov.databinding.WeatherFragmentListBinding
import com.example.kotlincourseappivanov.viewmodel.AppState

class WeatherFragmentList:Fragment() {


    private var _binding: WeatherFragmentListBinding? = null
    private val binding: WeatherFragmentListBinding
        get() {
            return _binding!!
        }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WeatherFragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = (arguments?.getParcelable<Weather>(BUNDLE_WEATHER_EXTRA))
        if (weather != null)
            renderData(weather)
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {/*TODO() HW*/
            }
            AppState.Loading -> {/*TODO() HW*/
            }
            is AppState.SuccessSingle -> {
                val result = appState.weatherData

            }
            is AppState.SuccessMulti -> {
                binding.weatherListFragmentRecyclerView.adapter = WeatherListAdapter(appState.weatherList, this)
            }
        }
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
