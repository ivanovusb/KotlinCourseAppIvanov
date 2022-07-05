package com.example.kotlincourseappivanov.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincourseappivanov.AppState

class WeatherViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()): ViewModel() {

}