package com.example.weatherapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.domain.entities.City
import com.example.weatherapp.R
import com.example.weatherapp.contracts.CityContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.BEFORE
import com.example.weatherapp.utils.Status.DONE
import com.example.weatherapp.utils.startActivity
import com.example.weatherapp.viewmodels.CityMainViewModel
import kotlinx.android.synthetic.main.activity_city.buttonDone
import kotlinx.android.synthetic.main.activity_city.main_edit_text_country
import org.json.JSONArray
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityMainActivity : AppCompatActivity(), CityContract.View {

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
            BEFORE -> {
                readJSONFile()
            }
            DONE -> {
                nextActivityIntent()
            }
        }
    }

    override fun nextActivityIntent() {
        startActivity<DetailsCityActivity>(NAME, getCityId())
    }

    override fun readJSONFile() {
        val json = applicationContext.assets.open(FILE_NAME).bufferedReader().use {
            it.readText()
        }
        createCityList(json)
    }

    private fun createCityList(json: String?) {
        val jsonArray = JSONArray(json)
        viewModel.createCityList(jsonArray)
        setCityListAdapter()
    }

    private fun setCityListAdapter() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfNameOfCity)
        main_edit_text_country.setAdapter(adapter)
    }

    private fun getCityId(): Int = viewModel.getCityId(main_edit_text_country.text.toString())

    companion object {
        var listOfCity = mutableListOf<City>()
        var listOfNameOfCity = mutableListOf<String>()
        const val ID = "id"
        const val NAME = "name"
        const val COUNTRY = "country"
        private const val FILE_NAME = "city.list.json"
        const val COUNTRY_AR = "AR"
    }
}
