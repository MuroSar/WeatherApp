package com.example.weatherapp.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.domain.entities.City
import com.example.weatherapp.R
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.DONE
import com.example.weatherapp.utils.Status.INIT
import com.example.weatherapp.utils.startActivity
import com.example.weatherapp.viewmodels.CityMainViewModel
import com.example.weatherapp.viewmodels.CityMainViewModel.Companion.NAME
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_city.buttonDone
import kotlinx.android.synthetic.main.activity_city.main_edit_text_country

@AndroidEntryPoint
class CityMainActivity : AppCompatActivity() {

    private val viewModel: CityMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        viewModel.mainState.observe(this, Observer { updateUI(it) })

        buttonDone.setOnClickListener { viewModel.buttonDonePressed() }

        viewModel.initAutoCompleteTextViewState()
    }

    private fun updateUI(weatherData: Event<Data<City>>) {
        when (weatherData.peekContent().status) {
            INIT -> {
                setCityListAdapter(weatherData.peekContent().listOfCities)
            }
            DONE -> {
                startActivity<DetailsCityActivity>(NAME, getCityId())
            }
            else -> {
                Toast.makeText(this, MESSAGE_ERROR, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setCityListAdapter(listOfCities: List<String>) {
        main_edit_text_country.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfCities))
    }

    private fun getCityId(): Int = viewModel.getCityId(main_edit_text_country.text.toString())

    companion object {
        private const val MESSAGE_ERROR = "ERROR"
    }
}
