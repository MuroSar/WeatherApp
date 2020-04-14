package com.example.weatherapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.domain.entities.City
import com.example.weatherapp.R
import com.example.weatherapp.contracts.SplashScreenContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.CHARGED_JSON
import com.example.weatherapp.utils.Status.INIT
import com.example.weatherapp.utils.startActivity
import com.example.weatherapp.viewmodels.SplashScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenActivity : AppCompatActivity() {

    private val viewModel by viewModel<SplashScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        viewModel.mainState.observe(this, Observer { updateUI(it) })

        viewModel.initJSON()
    }

    private fun updateUI(splashData: Event<Data<City>>) {
        when (splashData.peekContent().status) {
            INIT -> {
                readJSONFile()
            }
            CHARGED_JSON -> {
                startActivity<CityMainActivity>(null, null)
            }
            else -> {
                Toast.makeText(this, MESSAGE, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readJSONFile() {
        val json = applicationContext.assets.open(FILE_NAME).bufferedReader().use {
            it.readText()
        }
        viewModel.createCityList(json)
    }

    companion object {
        private const val FILE_NAME = "city.list.json"
        private const val MESSAGE = "ERROR"
    }
}
