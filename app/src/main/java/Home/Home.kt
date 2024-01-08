package com.example.reacherj

import Shopping.Shopping
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_item_1 -> {
                    startActivity(Intent(this, Home::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_item_2 -> {
                    startActivity(Intent(this, Favorite::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_item_3 -> {
                    startActivity(Intent(this, Shopping::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_item_4 -> {
                    startActivity(Intent(this, Mapa::class.java))
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}



