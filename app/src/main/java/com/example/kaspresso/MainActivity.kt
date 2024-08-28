package com.example.kaspresso

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var currentValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.increment).setOnClickListener(this::incrementAction)
        findViewById<Button>(R.id.decrement).setOnClickListener(this::decrementAction)
        findViewById<Button>(R.id.reset).setOnClickListener(this::resetAction)
    }

    private fun incrementAction(view: View){
        updateCounterText(++currentValue)
    }

    private fun decrementAction(view: View){
        updateCounterText(--currentValue)
    }

    private fun resetAction(view: View){
        currentValue = 0
        updateCounterText(currentValue)
    }

    private fun updateCounterText(value: Int){
        findViewById<TextView>(R.id.counter).text = String.format("Count: %d", value)
    }
}