package com.example.weatherapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.R
import com.example.weatherapp.viewmodels.DetailsCityViewModel

class CityMainActivity : AppCompatActivity() {

    private val viewmodel by viewmodel<DetailsCityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
    }
}
