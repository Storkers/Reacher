package com.example.reacherj

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Maps: AppCompatActivity()
{
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.maps)

        val buttonBack = findViewById<Button>(R.id.buttonMapBack)
        buttonBack.setOnClickListener{
            finish() // Chama o método padrão de voltar
        }
    }
}