package com.example.superbikerentalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ToolbarActivity : AppCompatActivity() {

    lateinit var toolarrow:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        toolarrow=findViewById(R.id.tool)

        var intent=Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
}