package com.example.weatherapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.domain.entities.City
import com.example.weatherapp.R
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.viewmodels.CityMainViewModel
import kotlinx.android.synthetic.main.activity_city.buttonDone

class CityMainActivity : AppCompatActivity() {

    private val viewModel: CityMainViewModel = CityMainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        viewModel.mainState.observe(this, Observer { updateUI(it) })

        buttonDone.setOnClickListener {
            viewModel.buttonDonePressed()
            nextActivityIntent()}
    }

    private fun updateUI(weatherData: Event<Data<City>>){
        when(weatherData.peekContent().responseType) {
            //TODO catch every response type
        }
    }

    private fun nextActivityIntent() {
        val intent = Intent(this, DetailsCityActivity::class.java)
        startActivity(intent)
    }
}
