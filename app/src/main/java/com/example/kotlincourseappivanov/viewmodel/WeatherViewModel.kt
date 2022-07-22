package com.example.kotlincourseappivanov.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincourseappivanov.model.*
import java.security.SecureRandom

class WeatherViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
    ViewModel() {


    private fun getRandomState(one: Int = 1, zero: Int = 0): Boolean {
        val random = SecureRandom()
        random.setSeed(random.generateSeed(20))
        return (random.nextInt(one - zero + 1) + zero) == 1
    }

    private lateinit var repositorySingle: RepositorySingle
    private lateinit var repositoryMulti: RepositoryMulti


    fun getLiveData(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }


    private fun choiceRepository() {
        repositorySingle = if (isConnection()) {
            WeatherRepositoryRemote()
        } else {
            WeatherRepositoryLocal()
        }
        repositoryMulti = WeatherRepositoryLocal()
    }

    fun getWeatherListForRussia() {
        sentRequest(Location.Russia)
    }

    fun getWeatherListForWorld() {
        sentRequest(Location.World)
    }

    private fun sentRequest(location: Location) {
        liveData.value = AppState.Loading
        Thread {
            Thread.sleep(300L)
            if (getRandomState()) {
                liveData.postValue(AppState.Error(IllegalStateException("что то пошло не так!")))
            } else {
                liveData.postValue(AppState.SuccessMulti(repositoryMulti.getListWeather(location)))
            }
        }.start()
    }


    private fun isConnection(): Boolean {
        return false
    }
}