package com.example.reacherj

import Maps.Place
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceAdapter(private val placeList: List<Place>): RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> ()
{
    class PlaceViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        val placeImageView: ImageView = itemView.findViewById(R.id.imageLugar)
        val placeName: TextView = itemView.findViewById(R.id.nomeLugar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return PlaceViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {

        return placeList.size

    }
}