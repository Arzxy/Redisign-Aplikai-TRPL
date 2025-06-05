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

class LogoAdapter(private val logos: List<Int>) : RecyclerView.Adapter<LogoAdapter.LogoViewHolder>() {

    // Used to hold and manage the ImageView from the item_logo.xml layout.
    inner class LogoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logoImage: ImageView = itemView.findViewById(R.id.logoImage)
    }

    // Called to create a new item view (item_logo.xml) when needed.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo, parent, false)
        return LogoViewHolder(view)
    }

    // Sets the logo image into the ImageView based on the position in the logos list.
    override fun onBindViewHolder(holder: LogoViewHolder, position: Int) {
        holder.logoImage.setImageResource(logos[position])
    }

    // Determines the number of items (logos) to be displayed in the list.
    override fun getItemCount(): Int = logos.size
}