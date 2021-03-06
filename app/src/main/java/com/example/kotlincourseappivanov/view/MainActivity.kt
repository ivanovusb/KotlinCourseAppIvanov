package com.example.kotlincourseappivanov.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlincourseappivanov.R
import com.example.kotlincourseappivanov.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, WeatherFragmentList.newInstance())
                .commit()
        }
    }
}