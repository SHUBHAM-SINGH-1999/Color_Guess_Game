package com.example.color_guess_game.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.color_guess_game.Utils.ColorPicker
import com.example.color_guess_game.R

class UserOderAdapter(var list:MutableList<Int>):RecyclerView.Adapter<UserOderAdapter.viewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var inf = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return viewholder(inf)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.imageView.setBackgroundColor(Color.parseColor(ColorPicker.colors[list[position]]))
    }
    inner class viewholder(itemView: View) :ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.items_image)
    }
}