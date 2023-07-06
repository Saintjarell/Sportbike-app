package com.example.superbikerentalapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertionActivity : AppCompatActivity() {

    private lateinit var etEmpName: EditText
    private lateinit var etEmpAge: EditText
    private lateinit var etEmpArea: EditText
    private lateinit var btnSaveData: Button

    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)

        etEmpName = findViewById(R.id.name)
        etEmpAge = findViewById(R.id.age)
        etEmpArea = findViewById(R.id.area)
        btnSaveData = findViewById(R.id.btnSave)

        dbRef = FirebaseDatabase.getInstance().getReference("person")

        btnSaveData.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {

        //getting values
        val empName = etEmpName.text.toString()
        val empAge = etEmpAge.text.toString()
        val empArea = etEmpArea.text.toString()

        if (empName.isEmpty()) {
            etEmpName.error = "Please enter name"
        }
        if (empAge.isEmpty()) {
            etEmpAge.error = "Please enter age"
        }
        if (empArea.isEmpty()) {
            etEmpArea.error = "Please enter area of residence"
        }
        val empId = dbRef.push().key!!

        val person = PersonModel(empId, empName, empAge, empArea)

        dbRef.child(empId).setValue(person).addOnCompleteListener {
            Toast.makeText(this, "Data has been inserted successfully", Toast.LENGTH_LONG).show()

            etEmpName.text.clear()
            etEmpAge.text.clear()
            etEmpArea.text.clear()


        }.addOnFailureListener { err ->
            Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
        }

    }
}