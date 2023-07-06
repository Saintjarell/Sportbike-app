package com.example.superbikerentalapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.NonCancellable

class CommentsActivity : AppCompatActivity() {
    lateinit var submit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        submit=findViewById(R.id.button)

        submit.setOnClickListener {
            Toast.makeText(applicationContext,"you have clicked submit", Toast.LENGTH_LONG).show()
            var box= AlertDialog.Builder(this)

            box.setMessage("Do you want to submit your review ?")
            box.setPositiveButton("PROCEED", DialogInterface.OnClickListener { dialog, id -> finish() })
            box.setPositiveButton("CANCEL", DialogInterface.OnClickListener { dialog, id -> NonCancellable.cancel() })

            var alert=box.create()
            alert.setTitle("comments")
            alert.show()
        }
    }
}