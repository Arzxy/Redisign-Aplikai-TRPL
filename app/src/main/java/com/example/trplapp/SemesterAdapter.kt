package com.example.trplapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

// SemesterAdapter is used as an adapter for ViewPager2
// to display static layouts for each page (one per semester).
class SemesterAdapter(private val layoutList: List<Int>) : RecyclerView.Adapter<SemesterAdapter.ViewHolder>() {

    // ViewHolder holds the layout for each semester page
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    // Called when ViewPager2 needs a new ViewHolder (page)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        // Inflate the layout corresponding to the current page (semester)
        val view = layoutInflater.inflate(layoutList[viewType], parent, false)
        return ViewHolder(view)
    }

    // No binding needed because layouts are static (predefined in XML)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    // Returns the total number of pages (semesters)s
    override fun getItemCount(): Int = layoutList.size

    // Returns the view type for each position,
    // allowing each page to use a different layout
    override fun getItemViewType(position: Int): Int = position
}