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

// This adapter is used to display the CardItem list in ViewPager2
// Each page in ViewPager2 will display one card using the item_card.xml layout
class CardAdapter(private val cardList: List<CardItem>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    // ViewHolder holds views from item_card layout
    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconImage: ImageView = view.findViewById(R.id.iconImage)
        val titleText: TextView = view.findViewById(R.id.titleText)
        val descText: TextView = view.findViewById(R.id.descText)
    }

    // Called when ViewPager2 needs to create a new card view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    // Bind data from CardItem to each view in the card
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = cardList[position]
        holder.iconImage.setImageResource(item.iconResId)
        holder.titleText.text = item.title
        holder.descText.text = item.description
    }

    // Total number of cards to display
    override fun getItemCount(): Int = cardList.size
}