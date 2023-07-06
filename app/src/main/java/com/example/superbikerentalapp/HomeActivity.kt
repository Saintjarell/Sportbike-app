package com.example.superbikerentalapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancel



class HomeActivity : AppCompatActivity() {

    lateinit var sportbikes: CardView
    lateinit var comments: CardView
    lateinit var merch: CardView
    lateinit var location: CardView
    lateinit var customer: CardView
    lateinit var signout: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sportbikes = findViewById(R.id.cardbike)
        comments = findViewById(R.id.cardcomment)
        merch = findViewById(R.id.cardMerch)
        location=findViewById(R.id.cardlocation)
        customer=findViewById(R.id.cardcustomer)
        signout = findViewById(R.id.cardlogout)

        sportbikes.setOnClickListener {
            val intent=Intent(this,bikeActivity::class.java)
            startActivity(intent)
        }

        comments.setOnClickListener {
            val intent=Intent(this,CommentsActivity::class.java)
            startActivity(intent)
        }

        merch.setOnClickListener {
            var intent=Intent(this,MerchActivity::class.java)
            startActivity(intent)
        }

        location.setOnClickListener {
            var intent=Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        customer.setOnClickListener {
            var intent=Intent(this,CustomerActivity::class.java)
            startActivity(intent)
        }

        signout.setOnClickListener {
            Toast.makeText(applicationContext,"you have clicked logout",Toast.LENGTH_LONG).show()
            var box=AlertDialog.Builder(this)

            box.setMessage("Do you want to close this application ?")
            box.setPositiveButton("PROCEED",DialogInterface.OnClickListener { dialog, id -> finish() })
            box.setPositiveButton("CANCEL",DialogInterface.OnClickListener { dialog, id -> NonCancellable.cancel() })

            var alert=box.create()
            alert.setTitle("Superbike renting")
            alert.show()

        }
    }
}