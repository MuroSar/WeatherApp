package com.example.weatherapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R
import com.example.weatherapp.activities.CityMainActivity.Companion.NAME

class DetailsCityActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_city)

        val cityName = intent.getIntExtra(NAME, DEFAULT_ID)

        Toast.makeText(this, cityName.toString(), Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val DEFAULT_ID = 0
    }
}