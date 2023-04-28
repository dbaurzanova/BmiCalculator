package com.example.bmicalc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var count: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BmiCalc)
        setContentView(R.layout.activity_main)


        var btn = findViewById<Button>(R.id.btn)
        val height = findViewById<EditText>(R.id.height)
        val weight = findViewById<EditText>(R.id.weight)
        val result = findViewById<TextView>(R.id.result)
        val screen = findViewById<LinearLayout>(R.id.Screen)

        val yourRes = findViewById<TextView>(R.id.yourResText)
        val textRes = findViewById<TextView>(R.id.tres)

        btn.setOnClickListener {

            if(count % 2 == 0) {
                val h = (height.text).toString().toFloat() / 100
                val w = weight.text.toString().toFloat()
                val res = w / (h * h)

                if (w.toInt() <= 0 || h.toInt() <= 0) {
                    btn.text = "Reset"
                    yourRes.visibility = View.VISIBLE
                    yourRes.text = "Please Enter Correct Measures!"
                    count++
                }
                else{
                    if (res < 18.5) {
                        screen.setBackgroundColor(Color.CYAN)
                        textRes.text = "You are underweight"
                    } else if (res >= 18.5 && res < 25) {
                        screen.setBackgroundColor(Color.GREEN)
                        textRes.text = "You are of normal weight"
                    } else if (res >= 25 && res < 30) {
                        screen.setBackgroundColor(Color.YELLOW)
                        textRes.text = "You are overweight"
                    } else {
                        screen.setBackgroundColor(Color.RED)
                        textRes.text = "You are obese"
                    }

                    btn.text = "Reset"
                    result.text = "%.2f".format(res)
                    result.visibility = View.VISIBLE
                    textRes.visibility = View.VISIBLE
                    yourRes.visibility = View.VISIBLE
                    yourRes.text = "Your Result"

                    count++
                }
            }
            else{
                btn.text = "Calculate"
                screen.setBackgroundResource(R.drawable.gradient_button)
                textRes.visibility = View.INVISIBLE
                result.visibility = View.INVISIBLE
                yourRes.visibility = View.INVISIBLE
                height.setText("")
                weight.setText("")

                count++
            }
        }
    }
}