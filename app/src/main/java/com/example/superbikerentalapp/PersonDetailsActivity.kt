package com.example.superbikerentalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.FirebaseDatabase

class PersonDetailsActivity : AppCompatActivity() {

    private lateinit var tvEmpId: TextView
    private lateinit var tvEmpName: TextView
    private lateinit var tvEmpAge: TextView
    private lateinit var tvEmpArea: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_details)

        initView()
        setValuesToViews()


        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("Id").toString(),
                intent.getStringExtra("Name").toString()
            )
        }

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("Id").toString()
            )
        }

    }

    private fun initView() {
        tvEmpId = findViewById(R.id.tvId)
        tvEmpName = findViewById(R.id.tvName)
        tvEmpAge = findViewById(R.id.tvage)
        tvEmpArea = findViewById(R.id.area)

        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }

    private fun setValuesToViews() {
        tvEmpId.text = intent.getStringExtra("Id")
        tvEmpName.text = intent.getStringExtra("Name")
        tvEmpAge.text = intent.getStringExtra("Age")
        tvEmpArea.text = intent.getStringExtra("Salary")

    }

    private fun openUpdateDialog(
        Id: String,
        Name: String
    ) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_dialog, null)

        mDialog.setView(mDialogView)

        val etEmpName = mDialogView.findViewById<EditText>(R.id.etName)
        val etEmpAge = mDialogView.findViewById<EditText>(R.id.etAge)
        val etEmpArea = mDialogView.findViewById<EditText>(R.id.etArea)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)

        etEmpName.setText(intent.getStringExtra("Name").toString())
        etEmpAge.setText(intent.getStringExtra("Age").toString())
        etEmpArea.setText(intent.getStringExtra("Area of residence").toString())

        mDialog.setTitle("Updating $Name Record")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {
            updateEmpData(
                Id,
                etEmpName.text.toString(),
                etEmpAge.text.toString(),
                etEmpArea.text.toString()
            )

            Toast.makeText(applicationContext,  "Data Updated Successfully", Toast.LENGTH_LONG).show()

            //we are setting updated data to our textviews
            tvEmpName.text = etEmpName.text.toString()
            tvEmpAge.text = etEmpAge.text.toString()
            tvEmpArea.text = etEmpAge.text.toString()

            alertDialog.dismiss()
        }
    }

    private fun updateEmpData(
        id: String,
        name: String,
        age: String,
        area: String
    ) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Employees").child(id)
        val empInfo = PersonModel(id, age, area)
        dbRef.setValue(empInfo)
    }

    private fun deleteRecord(
        id: String
    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("person").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Data deleted", Toast.LENGTH_LONG).show()

            val intent = Intent(this, FetchingActivity::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{ error ->
            Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
        }
    }
}