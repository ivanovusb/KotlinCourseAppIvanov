package com.example.kotlincourseappivanov.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincourseappivanov.R
import com.example.kotlincourseappivanov.Weather
import com.example.kotlincourseappivanov.databinding.WeatherFragmentListBinding
import com.example.kotlincourseappivanov.viewmodel.AppState
import com.example.kotlincourseappivanov.viewmodel.WeatherViewModel

class WeatherFragmentList : Fragment(), OnItemClick {

    companion object {
        fun newInstance() = WeatherFragmentList()
    }

    private var _binding: WeatherFragmentListBinding? = null
    private val binding: WeatherFragmentListBinding
        get() {
            return _binding!!
        }

    var isRussian = true

    lateinit var viewModel: WeatherViewModel

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

        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                renderData(t)
            }
        })

        binding.weatherListFragmentFAB.setOnClickListener {
            isRussian = !isRussian
            if (isRussian) {
                viewModel.getWeatherListForRussia()
                binding.weatherListFragmentFAB.setImageResource(R.drawable.ic_russia)
            } else {
                viewModel.getWeatherListForWorld()
                binding.weatherListFragmentFAB.setImageResource(R.drawable.ic_earth)
            }
        }
        viewModel.getWeatherListForRussia()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {
                binding.showResult()
            }
            AppState.Loading -> {
                binding.loading()
            }
            is AppState.SuccessSingle -> {
                binding.showResult()
                val result = appState.weatherData
            }
            is AppState.SuccessMulti -> {
                binding.showResult()

                binding.weatherListFragmentRecyclerView.adapter =
                    WeatherListAdapter(appState.weatherList, this)
            }
        }
    }

    fun WeatherFragmentListBinding.loading() {
        binding.weatherListFragmentFAB.visibility = View.GONE
        binding.mainFragmentLoadingLayout.visibility = View.VISIBLE

    }

    fun WeatherFragmentListBinding.showResult() {
        binding.weatherListFragmentFAB.visibility = View.VISIBLE
        binding.mainFragmentLoadingLayout.visibility = View.GONE

    }

    override fun onItemClick(weather: Weather) {
        requireActivity().supportFragmentManager.beginTransaction().hide(this)
            .add(R.id.container, WeatherFragmentDetails.newInstance(weather)).addToBackStack("")
            .commit()
    }
}
