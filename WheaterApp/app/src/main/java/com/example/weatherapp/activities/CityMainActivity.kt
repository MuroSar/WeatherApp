package com.example.weatherapp.activities

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.domain.entities.City
import com.example.weatherapp.R
import com.example.weatherapp.contracts.CityContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.ERROR
import com.example.weatherapp.utils.Status.INIT
import com.example.weatherapp.utils.Status.LOADING
import com.example.weatherapp.utils.Status.SUCCESSFUL
import com.example.weatherapp.utils.listOfCity
import com.example.weatherapp.utils.startActivity
import com.example.weatherapp.viewmodels.CityMainViewModel
import kotlinx.android.synthetic.main.activity_city.buttonDone
import kotlinx.android.synthetic.main.activity_city.main_edit_text_country
import kotlinx.android.synthetic.main.activity_city.progressBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityMainActivity : AppCompatActivity(), CityContract.View {

    private val viewModel by viewModel<CityMainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        viewModel.mainState.observe(this, Observer { updateUI(it) })

        buttonDone.setOnClickListener { viewModel.buttonDonePressed() }

        main_edit_text_country.setOnClickListener { viewModel.getListOfCities() }
    }

    private fun updateUI(weatherData: Event<Data<City>>) {
        when (weatherData.peekContent().status) {
            INIT -> {
                getCityList()
            }
            LOADING -> {
                showLoading()
            }
            SUCCESSFUL -> {
                hideLoading()
                nextActivityIntent()
            }
            ERROR -> {
                hideLoading()
                showErrorMessage()
            }
        }
    }

    override fun nextActivityIntent() {
        startActivity<DetailsCityActivity>()
    }

    override fun getCityList() {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfCity)
        main_edit_text_country.setAdapter(adapter)
    }

    private fun showErrorMessage() {
        Toast.makeText(this, MESSAGE, Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    companion object {
        const val MESSAGE = "Some error"
    }
}
