package com.example.trplapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import android.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.compose.ui.semantics.dismiss
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class Home : AppCompatActivity() {

    // UNTUK DOTS PADA PAGE SCROLL INFORMASI
    private lateinit var viewPager: ViewPager2
    private lateinit var dotsIndicator: DotsIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // BUAT BUTTON INTERACTIVE
        // Here the first thing to initialize first is to take the id to enter it into the variable
        val visiHeader = findViewById<LinearLayout>(R.id.visiHeader)
        val visiContent = findViewById<TextView>(R.id.visiContent)
        val visiArrow = findViewById<ImageView>(R.id.visiArrow)

        val misiHeader = findViewById<LinearLayout>(R.id.misiHeader)
        val misiContent = findViewById<TextView>(R.id.misiContent)
        val misiArrow = findViewById<ImageView>(R.id.misiArrow)

        val tujuanHeader = findViewById<LinearLayout>(R.id.tujuanHeader)
        val tujuanContent = findViewById<TextView>(R.id.tujuanContent)
        val tujuanArrow = findViewById<ImageView>(R.id.tujuanArrow)

        // This works when the element with the id visiHeader is pressed, the contents of the visiContent will appear.
        visiHeader.setOnClickListener {
            // When the visiContent visibility is Gone or not displayed will execute its contents
            if (visiContent.visibility == View.GONE) {
                buka(visiContent)
                visiArrow.setImageResource(R.drawable.img_9)
                visiHeader.setBackgroundResource(R.drawable.bg_card_greenv2)

            // If the visibility is present or displayed will execute the content
            } else {
                tutup(visiContent)
                visiArrow.setImageResource(R.drawable.img_8)
                visiHeader.setBackgroundResource(R.drawable.bg_card_brown)
            }
        }

        // This is the same as the flow earlier
        misiHeader.setOnClickListener {
            if (misiContent.visibility == View.GONE) {
                buka(misiContent)
                misiArrow.setImageResource(R.drawable.img_9)
                misiHeader.setBackgroundResource(R.drawable.bg_card_greenv2)
            } else {
                tutup(misiContent)
                misiArrow.setImageResource(R.drawable.img_8)
                misiHeader.setBackgroundResource(R.drawable.bg_card_brown)
            }
        }

        // This is the same as the flow earlier
        tujuanHeader.setOnClickListener {
            if (tujuanContent.visibility == View.GONE) {
                buka(tujuanContent)
                tujuanArrow.setImageResource(R.drawable.img_9)
                tujuanHeader.setBackgroundResource(R.drawable.bg_card_greenv2)
            } else {
                tutup(tujuanContent)
                tujuanArrow.setImageResource(R.drawable.img_8)
                tujuanHeader.setBackgroundResource(R.drawable.bg_card_brown)
            }
        }

        // This is the same as the flow earlier
        val utamaHeader = findViewById<LinearLayout>(R.id.utamaHeader)
        val utamaContent = findViewById<TextView>(R.id.utamaContent)
        val utamaArrow = findViewById<ImageView>(R.id.utamaArrow)
        val utamaTitle = findViewById<TextView>(R.id.utamaTitle)

        val pendukungHeader = findViewById<LinearLayout>(R.id.pendukungHeader)
        val pendukungContent = findViewById<TextView>(R.id.pendukungContent)
        val pendukungArrow = findViewById<ImageView>(R.id.pendukungArrow)
        val pendukungTitle = findViewById<TextView>(R.id.pendukungTitle)

        val lainnyaHeader = findViewById<LinearLayout>(R.id.lainnyaHeader)
        val lainnyaContent = findViewById<TextView>(R.id.lainnyaContent)
        val lainnyaArrow = findViewById<ImageView>(R.id.lainnyaArrow)
        val lainnyaTitle = findViewById<TextView>(R.id.lainnyaTitle)

        // This is the same as the flow earlier
        utamaHeader.setOnClickListener {
            if (utamaContent.visibility == View.GONE) {
                buka(utamaContent)
                utamaArrow.setImageResource(R.drawable.img_9)
                utamaHeader.setBackgroundResource(R.drawable.bg_card_greenv2)
                utamaTitle.setTextColor(Color.WHITE)
            } else {
                tutup(utamaContent)
                utamaArrow.setImageResource(R.drawable.img_6)
                utamaHeader.setBackgroundResource(R.drawable.bg_card_white)
                utamaTitle.setTextColor(Color.BLACK)
            }
        }

        // This is the same as the flow earlier
        pendukungHeader.setOnClickListener {
            if (pendukungContent.visibility == View.GONE) {
                buka(pendukungContent)
                pendukungArrow.setImageResource(R.drawable.img_9)
                pendukungHeader.setBackgroundResource(R.drawable.bg_card_greenv2)
                pendukungTitle.setTextColor(Color.WHITE)
            } else {
                tutup(pendukungContent)
                pendukungArrow.setImageResource(R.drawable.img_6)
                pendukungHeader.setBackgroundResource(R.drawable.bg_card_white)
                pendukungTitle.setTextColor(Color.BLACK)
            }
        }

        // This is the same as the flow earlier
        lainnyaHeader.setOnClickListener {
            if (lainnyaContent.visibility == View.GONE) {
                buka(lainnyaContent)
                lainnyaArrow.setImageResource(R.drawable.img_9)
                lainnyaHeader.setBackgroundResource(R.drawable.bg_card_greenv2)
                lainnyaTitle.setTextColor(Color.WHITE)
            } else {
                tutup(lainnyaContent)
                lainnyaArrow.setImageResource(R.drawable.img_6)
                lainnyaHeader.setBackgroundResource(R.drawable.bg_card_white)
                lainnyaTitle.setTextColor(Color.BLACK)
            }
        }
        // END

        // NAV BAR
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        // Mark the “Home” item as the currently active item
        bottomNavigationView.selectedItemId = R.id.nav_home

        // Listener to handle clicks on bottom navigation items
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // If the “Home” item is clicked, stay on the Home page
                R.id.nav_home -> {
                    startActivity(Intent(this, Home::class.java))
                    true
                }
                // If “Lecturer” item is clicked, move to Lecturer activity
                R.id.nav_dosen -> {
                    startActivity(Intent(this, Dosen::class.java))
                    true
                }
                // If the “Testimonial” item is clicked, move to the Testimonial activity
                R.id.nav_testimonial -> {
                    startActivity(Intent(this, Testimonial::class.java))
                    true
                }
                // If the “Facilities” item is clicked, move to the Facilities activity
                R.id.nav_fasilitas -> {
                    startActivity(Intent(this, Fasilitas::class.java))
                    true
                }
                else -> false
            }
        }
        // END

        // UNTUK SCROLL + DOTS PADA PAGE SCROLL INFORMASI
        // Setup ViewPager2 and dots indicator for scrolling through info pages
        viewPager = findViewById(R.id.viewPager)
        dotsIndicator = findViewById(R.id.dotsIndicator)

        // List of cards to show in the ViewPager2
        val cardList = listOf(
            CardItem(
                R.drawable.img_10,
                "Pengetahuan Dasar IT & Programming",
                "Pengantar Lunak Aplikasi; Pemrograman Dasar; Struktur Data; OOP; Basis Data; Sistem Operasi; Perancangan UI/UX."
            ),
            CardItem(
                R.drawable.img_13,  // ganti dengan ikon kamu
                "Cyber Security & Computer Network",
                "Dasar Keamanan Komputer; Keamanan Perangkat Lunak; Keamanan Basis Data; Komunikasi Data & Jaringan; Sistem Transmisi; Cloud Computing."
            ),
            CardItem(
                R.drawable.img_14,
                "Web Design dan Programming",
                "HTML; CSS; Java Script; Bootstrap; PHP; MySql; Laravel; Vue.JS/React.JS."
            ),
            CardItem(
                R.drawable.img_19,
                "Rekayasa Perangkat Lunak",
                "Pengantar Rekayasa Perangkat Lunak; Analisis &amp; Desain Perangkat Lunak; Pengujian Perangkat Lunak; Manajemen Proyek."
            ),
            CardItem(
                R.drawable.img_16,
                "Math &amp; Data Processing",
                "Kalkulus; Aljabar Linear; Matematika Diskrit; Statistik; Data Mining."
            ),
            CardItem(
                R.drawable.img_18,
                "English",
                "Vocabulary; Reading; Speaking; Listening; Grammar; Writing; English fo Career; TOEIC."
            ),
            CardItem(
                R.drawable.img_17,
                "Success Skill",
                "Teknik Presentasi; Manajemen kearsipan;Etika Profesi; Technopreneur; Magang/Internship; Tugas Akhir / Projek Akhir,"
            ),
            CardItem(
                R.drawable.img_12,
                "Android Programming",
                "Activity dan Intent; Layout; Style dan Theme; List dan Recycle View; Navigation; Background Process dan Networking; Restful API; ViewModel dan LiveData; Testing; Local Data Persistent; Background Task dan Schheduler; Basic Flutter."
            ),
        )

        // Create adapter with the card list and attach to ViewPager
        val adapter = CardAdapter(cardList)
        viewPager.adapter = adapter

        // Attach dots indicator to ViewPager2 to show scroll position
        dotsIndicator.setViewPager2(viewPager)
        // END

        // UNTUK SCROLL + DOTS PADA PAGE SCROLL SEMESTER
        // Setup ViewPager2 and dots indicator for scrolling through Semester
        val viewPagerSemester = findViewById<ViewPager2>(R.id.viewPagerSemester)
        val dotsIndicatorSemester = findViewById<DotsIndicator>(R.id.dotsIndicatorSemester)

        // This is the list of XML layout resources for each semester page.
        val layouts = listOf(
            R.layout.semester_1_layout,
            R.layout.semester_2_layout,
            R.layout.semester_3_layout,
            R.layout.semester_4_layout,
            R.layout.semester_5_layout,
            R.layout.semester_6_layout,
            R.layout.semester_7_layout,
            R.layout.semester_8_layout,
        )

        // bertujuan untuk menghubungkan adapter dengan ViewPager2, sehingga setiap halaman akan mengambil layout dari daftar tersebut.
        viewPagerSemester.adapter = SemesterAdapter(layouts)
        // aims to connect the dot indicator with ViewPager2, so that the number of dots and their active positions match the page.
        dotsIndicatorSemester.setViewPager2(viewPagerSemester)
        // END
    }








    // INI BUAT ANIMASI TUTUP / BUKA (buka / tutup)
    fun buka(view: View) {
        view.measure(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val targetHeight = view.measuredHeight
        view.layoutParams.height = 0
        view.visibility = View.VISIBLE

        val animation = object : android.view.animation.Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: android.view.animation.Transformation?) {
                view.layoutParams.height = if (interpolatedTime == 1f)
                    LinearLayout.LayoutParams.WRAP_CONTENT
                else
                    (targetHeight * interpolatedTime).toInt()
                view.requestLayout()
            }

            override fun willChangeBounds(): Boolean = true
        }

        animation.duration = (targetHeight / view.context.resources.displayMetrics.density).toLong() * 2
        view.startAnimation(animation)
    }
    fun tutup(view: View) {
        val initialHeight = view.measuredHeight

        val animation = object : android.view.animation.Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: android.view.animation.Transformation?) {
                if (interpolatedTime == 1f) {
                    view.visibility = View.GONE
                } else {
                    view.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                    view.requestLayout()
                }
            }

            override fun willChangeBounds(): Boolean = true
        }

        animation.duration = (initialHeight / view.context.resources.displayMetrics.density).toLong() * 2
        view.startAnimation(animation)
    }
    // END
}
