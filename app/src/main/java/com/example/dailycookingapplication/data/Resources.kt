package com.example.dailycookingapplication.data

import androidx.annotation.DrawableRes


data class Resources(
        val recipe:String,
        val recipeDescription: String,
        val day: Int,
        @DrawableRes val imageResourceId: Int
)

