package com.example.pizzeriadatizianoandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzeriadatizianoandroid.R
import com.example.pizzeriadatizianoandroid.data.Pizze

class PizzeAdapter(private val context: Context?) : RecyclerView.Adapter<PizzeAdapter.PizzeViewHolder>(){


    private val pizze = Pizze.pizze


    //Define every element of the list
    class PizzeViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.card_title)
        val image: ImageView = view.findViewById(R.id.card_image)
        val price: TextView = view.findViewById(R.id.card_text)
        val description: TextView = view.findViewById(R.id.card_text_2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzeViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return PizzeViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = pizze.size
    override fun onBindViewHolder(holder: PizzeViewHolder, position: Int) {
        val pizza = pizze[position]
        holder.name.text = pizza.name
        holder.description.text = pizza.description
        holder.image.setImageResource(pizza.image)
        holder.price.text = pizza.price.toString()
    }



}