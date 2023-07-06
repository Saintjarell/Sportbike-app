package com.example.superbikerentalapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MerchActivity : AppCompatActivity() {
    lateinit var shirt:CardView
    lateinit var trouser:CardView
    lateinit var cap:CardView
    lateinit var hoodie:CardView
    lateinit var helmet:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merch)

        shirt=findViewById(R.id.card6)
        trouser=findViewById(R.id.card7)
        hoodie=findViewById(R.id.card8)
        cap=findViewById(R.id.card9)
        helmet=findViewById(R.id.card10)

        shirt.setOnClickListener {
            val intent=Intent(this,merch::class.java)
            startActivity(intent)
        }
    }
}