package com.example.superbikerentalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ApriliaActivity : AppCompatActivity() {

    lateinit var btn: Button
    lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aprilia)

        btn=findViewById(R.id.btn9)
        btn1=findViewById(R.id.btn10)

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