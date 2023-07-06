package com.example.superbikerentalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class YamahaActivity : AppCompatActivity() {

    lateinit var text: TextView
    lateinit var text1: TextView
    lateinit var btn: Button
    lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yamaha)

        btn=findViewById(R.id.btn3)
        btn1=findViewById(R.id.btn4)

        btn.setOnClickListener {
            var simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let{startActivity(it)}
        }

        btn1.setOnClickListener {
            var simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let{startActivity(it)}

        }
    }
}
