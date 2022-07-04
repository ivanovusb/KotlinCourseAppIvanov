package com.example.kotlincourseappivanov.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlincourseappivanov.databinding.WeatherFragmentBinding

class WeatherFragment: Fragment() {

    companion object {
        fun newInstance() = WeatherFragment()
    }

    private lateinit var binding: WeatherFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WeatherFragmentBinding.inflate(inflater)
        return binding.root

    }


}