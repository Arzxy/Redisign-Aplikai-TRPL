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
// Displays each testimonial item in the item_testimoni.xml layout
class TestimoniAdapter(private val testimoniList: List<TestimoniItem>) :
    RecyclerView.Adapter<TestimoniAdapter.TestimoniViewHolder>() {

    inner class TestimoniViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deskripsiText: TextView = view.findViewById(R.id.deskripsiText)
        val namaText: TextView = view.findViewById(R.id.namaText)
        val tanggalText: TextView = view.findViewById(R.id.tanggalText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimoniViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_testimoni, parent, false)
        return TestimoniViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestimoniViewHolder, position: Int) {
        val item = testimoniList[position]
        holder.deskripsiText.text = item.deskripsi
        holder.namaText.text = item.nama
        holder.tanggalText.text = item.tanggal
    }

    override fun getItemCount(): Int = testimoniList.size
}