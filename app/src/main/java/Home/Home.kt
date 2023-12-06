package com.example.reacherj


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class Home : AppCompatActivity()
{
        private lateinit var bottomNavigationView: BottomNavigationView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.home)

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
                            val wish = Intent(this, Maps::class.java)
                            startActivity(wish)

                            true
                        }

                    else -> false
                }
            }
        }
}
