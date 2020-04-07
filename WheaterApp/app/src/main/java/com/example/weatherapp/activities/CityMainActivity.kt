package com.example.weatherapp.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.domain.entities.City
import com.example.weatherapp.R
import com.example.weatherapp.contracts.CityContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.listOfCity
import com.example.weatherapp.utils.startActivity
import com.example.weatherapp.viewmodels.CityMainViewModel
import kotlinx.android.synthetic.main.activity_city.buttonDone
import kotlinx.android.synthetic.main.activity_city.main_edit_text_country

class CityMainActivity : AppCompatActivity(), CityContract.View {

    private val viewModel: CityMainViewModel = CityMainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        viewModel.mainState.observe(this, Observer { updateUI(it) })

        buttonDone.setOnClickListener { viewModel.buttonDonePressed()
            nextActivityIntent()
        }

        getCityList()
    }

    private fun updateUI(weatherData: Event<Data<City>>){
        when(weatherData.peekContent().responseType) {
            //TODO catch every response type
        }
    }

    //It's gonna be used in the next PR.
    override fun nextActivityIntent() {
        startActivity<DetailsCityActivity>()
    }

    override fun getCityList() {
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listOfCity)
        main_edit_text_country.setAdapter(adapter)
    }
}
