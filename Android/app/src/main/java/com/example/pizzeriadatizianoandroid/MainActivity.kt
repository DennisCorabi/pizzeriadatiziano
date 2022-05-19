package com.example.pizzeriadatizianoandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizzeriadatizianoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val intent: Intent = when(item.itemId){
                R.id.order_main -> {
                    Intent(this, MainActivity::class.java)
                }
                else ->{
                    Intent(this, PizzeActivity::class.java)
                }
            }
            startActivity(intent)
            return@setOnItemSelectedListener true
        }

        binding.orderPizzeButton.setOnClickListener{
            val intent = Intent(this, PizzeActivity::class.java)
            startActivity(intent)
        }

    }
}