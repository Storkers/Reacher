package com.example.reacherj

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.reacherj.R

class Login : AppCompatActivity()
{
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val buttonBack = findViewById<Button>(R.id.buttonLoginBack)
        buttonBack.setOnClickListener {
            finish() // Chama o método padrão de voltar
        }

        }


}