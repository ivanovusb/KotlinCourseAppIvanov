package com.example.kotlincourseappivanov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kotlincourseappivanov.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPressMe : Button = findViewById(R.id.press_me_button)


        btnPressMe.setOnClickListener {
            Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show()



        }
    }
}