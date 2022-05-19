package com.example.pizzeriadatizianoandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzeriadatizianoandroid.adapters.PizzeAdapter
import com.example.pizzeriadatizianoandroid.databinding.ActivityPizzeBinding

class PizzeActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPizzeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pizzeList.adapter = PizzeAdapter(applicationContext)

    }
}