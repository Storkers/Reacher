package com.example.reacherj

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Favorite: AppCompatActivity()
    {
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?)
        {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.favorite)

            val buttonBack = findViewById<Button>(R.id.buttonFavoriteBack)
            buttonBack.setOnClickListener {
                finish() // Chama o método padrão de voltar
            }

        }
}