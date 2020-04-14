package com.example.weatherapp.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.domain.entities.City
import com.example.weatherapp.R
import com.example.weatherapp.contracts.CityContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.DONE
import com.example.weatherapp.utils.Status.INIT
import com.example.weatherapp.utils.startActivity
import com.example.weatherapp.viewmodels.CityMainViewModel
import com.example.weatherapp.viewmodels.CityMainViewModel.Companion.NAME
import com.example.weatherapp.viewmodels.CityMainViewModel.Companion.listOfCities
import kotlinx.android.synthetic.main.activity_city.buttonDone
import kotlinx.android.synthetic.main.activity_city.main_edit_text_country
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityMainActivity : AppCompatActivity() {

    private val viewModel by viewModel<CityMainViewModel>()

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
                setCityListAdapter()
            }
            DONE -> {
                startActivity<DetailsCityActivity>(NAME, getCityId())
            }
            else -> {
                Toast.makeText(this, MESSAGE_ERROR, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setCityListAdapter() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfCities)
        main_edit_text_country.setAdapter(adapter)
    }

    private fun getCityId(): Int = viewModel.getCityId(main_edit_text_country.text.toString())

    companion object {
        private const val MESSAGE_ERROR = "ERROR"
    }
}
