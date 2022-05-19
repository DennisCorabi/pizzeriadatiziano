package com.example.pizzeriadatizianoandroid.data

import com.example.pizzeriadatizianoandroid.R

object Pizze {
    val pizze: List<Pizza> = listOf(
        Pizza(
            R.drawable.margherita,
            "Margherita",
            "Pomodoro, mozzarella e basilico",
            10
        ),
        Pizza(
            R.drawable.diavola,
            "Diavola",
            "Pomodoro, mozzarella e salame piccante",
            12
        ),
        Pizza(
            R.drawable.marinara,
            "Marinara",
            "Pomodoro, olio e basilico",
            20
        ),
        Pizza(
            R.drawable.quattrostagioni,
            "Quattro stagioni",
            "Pomodoro, mozzarella, olive nere e prosciutto",
            20

        )
    )
}