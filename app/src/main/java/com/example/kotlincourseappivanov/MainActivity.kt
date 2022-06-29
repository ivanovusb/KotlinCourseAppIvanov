package com.example.kotlincourseappivanov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.kotlincourseappivanov.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPressMe: Button = findViewById(R.id.press_me_button)
        val someData = SomeDataClass(123, "id")
        val txtViewOne: TextView = findViewById(R.id.text)
        val txtViewTwo: TextView = findViewById(R.id.text_2)
        val someDataTwo = someData.copy()

        btnPressMe.setOnClickListener {
            Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show()
            txtViewOne.text = someData.toString()
            txtViewTwo.text = someDataTwo.toString()

        }

        someCycles()
    }

    fun someCycles() {
        val array = intArrayOf(1, 5, 6, 23, 12, 4, 12, 65, 43, 21, 1, 9, 15)
        for (i in array.indices) {
            println(array[i])
        }

        for (i in 20 downTo 1 step 3) {
            println(i)
        }

        for (item in array) {
            println(item)
        }

        var index = 0
        while (index < array.size) {
            println("Item at $index is ${array[index]}")
            index++
        }
    }
}