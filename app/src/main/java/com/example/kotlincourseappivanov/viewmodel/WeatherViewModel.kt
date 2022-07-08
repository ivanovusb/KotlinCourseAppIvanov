package com.example.kotlincourseappivanov.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincourseappivanov.model.WeatherRepository
import com.example.kotlincourseappivanov.model.WeatherRepositoryLocal
import com.example.kotlincourseappivanov.model.WeatherRepositoryRemote

class WeatherViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()): ViewModel() {


    private lateinit var repository: WeatherRepository
    fun getLiveData(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }


    private fun choiceRepository() {
        repository = if (isConnection()) {
            WeatherRepositoryRemote()
        } else {
            WeatherRepositoryLocal()
        }
    }

    fun sentRequest() {
        liveData.value = AppState.Loading
        if ((0..3).random() != 1) {
            liveData.postValue(AppState.Error(throw IllegalStateException("что то пошло не так!")))
        } else {
            liveData.postValue(AppState.Success(repository.getWeather(55.755826, 37.128912841208)))
        }
    }

    private fun isConnection(): Boolean {
        return false
    }


}