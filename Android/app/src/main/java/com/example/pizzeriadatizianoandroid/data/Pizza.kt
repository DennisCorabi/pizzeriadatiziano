package com.example.pizzeriadatizianoandroid.data

import android.widget.ImageView
import androidx.annotation.DrawableRes

class Pizza(
    @DrawableRes val image: Int,
    val name: String,
    val description: String,
    val price: Int,
)