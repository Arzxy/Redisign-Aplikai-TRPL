package com.example.trplapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

// This data class is used to store data from one card (CardView)
// Each card contains an image/icon, title, and description
data class CardItem(
    val iconResId: Int,
    val title: String,
    val description: String
)