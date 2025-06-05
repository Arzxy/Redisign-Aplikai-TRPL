package com.example.trplapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class Testimonial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_testimonial)

        //BACK BUTTON
        val moveImg = findViewById<ImageView>(R.id.backButton)

        moveImg.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        // END

        // NAV BAR
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.nav_testimonial

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

        // GAMBAR MITRA
        // Provides image data for logos
        val logoList = listOf(
            R.drawable.img_35,
            R.drawable.img_36,
            R.drawable.img_34,
            R.drawable.img_37,
            R.drawable.img_38
        )

        val recyclerView = findViewById<RecyclerView>(R.id.logoCarousel)
        // Sets the adapter for the RecyclerView
        recyclerView.adapter = LogoAdapter(logoList)
        // Arranges the logos in a horizontal row
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // END

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dotsIndicator)

        // A list of testimonials to be displayed
        val testimoniList = listOf(
            TestimoniItem(
                "Pengalaman saya selama kuliah di PEI saya mendapatkan ilmu yang saya sukai, seperti mendesain aplikasi dan pemrograman. Dengan metode pembelajaran yang lebih banyak praktek membuat saya tidak bosan belajar dikelas.",
                "Dina Armei – TRPL ‘21",
                "21 Mei 2025"
            ),
            TestimoniItem(
                "Saya senang kuliah di PEI karena fasilitas lab disini sangat lengkap sehingga proses pembelajaran dapat dilakukan dengan maksimal.",
                "Muhammad Daris – TRPL ’21",
                "19 Mei 2025"
            ),
            TestimoniItem(
                "Saya sangat senang kuliah PEI karena dosen- nya baik dan selalu membantu saya ketika menghadapi kesulitan dalam pembelajaran. Selain itu dosennya juga sangat berkopenten dalam bidangnya masing-masing",
                "Annisa Zachry – TRPL ’20",
                "19 Mei 2025"
            )
        )

        // Connects the ViewPager2 with the adapter to show each page
        val adapter = TestimoniAdapter(testimoniList)
        viewPager.adapter = adapter
        dotsIndicator.setViewPager2(viewPager)
    }
}