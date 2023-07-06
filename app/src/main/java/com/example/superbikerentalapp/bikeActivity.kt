package com.example.superbikerentalapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class bikeActivity : AppCompatActivity() {

    lateinit var kawasaki:CardView
    lateinit var yamaha:CardView
    lateinit var bmw:CardView
    lateinit var ducati:CardView
    lateinit var aprilia:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike)

        kawasaki=findViewById(R.id.card1)
        yamaha=findViewById(R.id.card2)
        bmw=findViewById(R.id.card3)
        ducati=findViewById(R.id.card4)
        aprilia=findViewById(R.id.card5)

        kawasaki.setOnClickListener {
            var kawasaki=Intent(this,kawasakiActivity::class.java)
            startActivity(kawasaki)
        }

        yamaha.setOnClickListener {
            var yamaha=Intent(this,YamahaActivity::class.java)
            startActivity(yamaha)
        }

        bmw.setOnClickListener {
            var bmw=Intent(this,BmwActivity::class.java)
            startActivity(bmw)
        }

        ducati.setOnClickListener {
            var ducati=Intent(this,DucatiActivity::class.java)
            startActivity(ducati)
        }

        aprilia.setOnClickListener {
            var aprilia=Intent(this,ApriliaActivity::class.java)
            startActivity(aprilia)
        }
    }
}