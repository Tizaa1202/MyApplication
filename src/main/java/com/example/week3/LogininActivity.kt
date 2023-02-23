package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LogininActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginin_activity)
    }

    fun onMatch(view: View) {
        val textId = findViewById<EditText>(R.id.editTextId)
        val textPass = findViewById<EditText>(R.id.editTextPassword)
        val textTitle = findViewById<TextView>(R.id.textViewtitle)

        if (textId.text.toString() == "login" && textPass.text.toString() == "123456") {
            Toast.makeText(this, "Login Successfully.", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
        }
    }
}