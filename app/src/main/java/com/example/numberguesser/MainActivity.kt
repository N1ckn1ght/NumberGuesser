package com.example.numberguesser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick_go(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        val editFrom = findViewById<EditText>(R.id.editFrom)
        val editTo = findViewById<EditText>(R.id.editTo)

        var l: Long = editFrom.text.toString().toLong()
        var r: Long = editTo.text.toString().toLong()

        intent.putExtra("l", l)
        intent.putExtra("r", r)
        startActivity(intent)
    }
}