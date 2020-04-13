package com.example.weatherapp.utils

import android.app.Activity
import android.content.Intent

inline fun <reified T> Activity.startActivity(string: String,id: Int) {
    startActivity(
            Intent(this, T::class.java).putExtra(string, id)
    )
}