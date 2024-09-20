package com.example.mobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val label = findViewById<TextView>(R.id.main_label)
        val dayNumber = findViewById<EditText>(R.id.main_namber)
        val showButton = findViewById<Button>(R.id.button)

        showButton.setOnClickListener {
            val dayNumberValue = dayNumber.text.toString().toIntOrNull()
            if (dayNumberValue != null && dayNumberValue in 1..7) {
                val dayName = getDayName(dayNumberValue)
                label.text = "День недели: $dayName"
            } else {
                label.text = "Неверный номер дня!"
            }
        }
    }





}