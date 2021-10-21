package com.example.numberguesser

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    var l: Long = 0
    var r: Long = 0
    var mid: Long = 0
    var iters: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        l = intent.getLongExtra("l", Long.MIN_VALUE + 1)
        r = intent.getLongExtra("r", Long.MAX_VALUE - 1)
        l -= 1
        calc()
    }

    fun onClick_less(view: View) {
        r = mid
        calc()
    }

    fun onClick_greater(view: View) {
        l = mid
        calc()
    }

    fun onClick_equal(view: View) {
        print("Your number is $mid!\nI've guessed it on a $iters try.")
    }

    fun calc() {
        val field = findViewById<TextView>(R.id.field)
        if (l + 1 < r) {
            mid = (l + r) / 2
            field.text = "The number is: $mid"
            iters += 1
        }
        else if (iters == 0) {
            print("Seems like there's no number to guess!")
        }
        else {
            if (l == mid) {
                print("No way! You've said before that your number is less than $r!\nGame is over, you lose!!")
            }
            else {
                print("No way! You've said before that your number is greater than $l!\nGame is over, you lose!!")
            }
        }
    }

    fun print(msg: String) {
        val intent = Intent(this, EndActivity::class.java)
        intent.putExtra("msg", msg)
        startActivity(intent)
    }
}