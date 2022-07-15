package com.example.kotlincourseappivanov.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincourseappivanov.model.WeatherRepository
import com.example.kotlincourseappivanov.model.WeatherRepositoryLocal
import com.example.kotlincourseappivanov.model.WeatherRepositoryRemote
import java.security.SecureRandom

class WeatherViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()): ViewModel() {


    private fun getRandomState(one: Int = 1, zero: Int = 0): Boolean {
        val random = SecureRandom()
        random.setSeed(random.generateSeed(20))
        return (random.nextInt(one - zero + 1) + zero) == 1
    }

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
        if (getRandomState()) {
            liveData.postValue(AppState.Error(throw IllegalStateException("что то пошло не так!")))
        } else {
            liveData.postValue(AppState.Success(repository.getWeather(55.755826, 37.128912841208)))
        }
    }

    private fun isConnection(): Boolean {
        return getRandomState()
    }
}