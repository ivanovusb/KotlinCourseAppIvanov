package com.example.kotlincourseappivanov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlincourseappivanov.databinding.ActivityMainBinding
import com.example.kotlincourseappivanov.view.WeatherFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}