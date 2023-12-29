package com.example.reacherj


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reacherj.Favorite
import com.example.reacherj.R
import com.example.reacherj.User
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Home : AppCompatActivity()
{
        private lateinit var bottomNavigationView: BottomNavigationView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.home)

            bottomNavigationView = findViewById(R.id.bottom_navigation)

            bottomNavigationView.setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {


                        R.id.navigation_favorites ->
                        {
                            val wish = Intent(this, Favorite::class.java)
                            startActivity(wish)

                            true
                        }

                    else -> false
                }
            }

            val buttonUser = findViewById<FloatingActionButton>(R.id.floatingActionButton)
            buttonUser.setOnClickListener{

                val intent2 = Intent(this, User::class.java);
                startActivity(intent2);}
            }
        }
