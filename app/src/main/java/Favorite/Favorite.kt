package com.example.reacherj

import Home.Home
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class Favorite: AppCompatActivity()
    {
        private lateinit var bottomNavigationView: BottomNavigationView
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?)
        {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.favorite)

            val buttonBack = findViewById<Button>(R.id.buttonFavoriteBack)
            buttonBack.setOnClickListener {
                finish() // Chama o método padrão de voltar
            }

            bottomNavigationView = findViewById(R.id.bottom_navigation)

            bottomNavigationView.setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {

                    R.id.navigation_home ->
                    {
                        val casa = Intent(this, Home::class.java)
                        startActivity(casa)
                        true
                    }

                    R.id.navigation_favorites ->
                    {
                        val wish = Intent(this, Favorite::class.java)
                        startActivity(wish)

                        true
                    }

                    R.id.navigation_map ->
                    {
                        val maps = Intent(this, Maps::class.java)
                        startActivity(maps)

                        true
                    }

                    else -> false
                }
            }

        }
}