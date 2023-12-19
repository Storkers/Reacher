package com.example.reacherj


import Home.Home
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val buttonLogin = findViewById<TextView>(R.id.loginButton)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        val buttonHome = findViewById<Button>(R.id.button1)
        buttonHome.setOnClickListener {
            val intent1 = Intent(this, Home::class.java)
            startActivity(intent1)
        }
    }
}