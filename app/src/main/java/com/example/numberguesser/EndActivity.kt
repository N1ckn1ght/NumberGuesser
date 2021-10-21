package com.example.numberguesser

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EndActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val msg = intent.getStringExtra("msg")
        val field = findViewById<TextView>(R.id.field)
        field.text = msg
    }

    fun onClick_reset(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}