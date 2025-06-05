package com.example.trplapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class Dosen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dosen)

        //BACK BUTTON
        val moveImg = findViewById<ImageView>(R.id.backButton)

        moveImg.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        // END

        // NAV BAR
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.nav_dosen

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, Home::class.java))
                    true
                }
                R.id.nav_dosen -> {
                    startActivity(Intent(this, Dosen::class.java))
                    true
                }
                R.id.nav_testimonial -> {
                    startActivity(Intent(this, Testimonial::class.java))
                    true
                }
                R.id.nav_fasilitas -> {
                    startActivity(Intent(this, Fasilitas::class.java))
                    true
                }
                else -> false
            }
        }
        // END
    }
}