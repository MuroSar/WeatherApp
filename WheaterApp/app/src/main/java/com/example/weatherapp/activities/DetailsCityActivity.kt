package com.example.weatherapp.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.domain.entities.City
import com.example.weatherapp.R
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.ERROR
import com.example.weatherapp.utils.Status.GETTING_DATA
import com.example.weatherapp.utils.Status.UPLOADED_DATA
import com.example.weatherapp.utils.startActivity
import com.example.weatherapp.viewmodels.CityMainViewModel.Companion.NAME
import com.example.weatherapp.viewmodels.DetailsCityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details_city.progressBar2
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_bar
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_celsius
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_coma
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_description
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_name_city
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_name_country
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_temp
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_temp_max
import kotlinx.android.synthetic.main.activity_details_city.text_view_details_activity_temp_min

@AndroidEntryPoint
class DetailsCityActivity : AppCompatActivity() {

    private val viewModel: DetailsCityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_city)

        viewModel.mainState.observe(this, Observer { updateUI(it) })

        viewModel.getInformationFromAPI(intent.getIntExtra(NAME, DEFAULT_INT))
    }

    private fun updateUI(data: Event<Data<City>>) {
        when (data.peekContent().status) {
            GETTING_DATA -> {
                hideInformation()
                progressBar2.visibility = View.VISIBLE
            }
            UPLOADED_DATA -> {
                progressBar2.visibility = View.GONE
                showInformation(data.peekContent().city)
            }
            ERROR -> {
                Toast.makeText(this, data.peekContent().error.toString() , Toast.LENGTH_LONG).show()
                startActivity<CityMainActivity>(null, null)
            }
        }
    }

    private fun hideInformation() {
        text_view_details_activity_coma.visibility = View.GONE
        text_view_details_activity_celsius.visibility = View.GONE
        text_view_details_activity_bar.visibility = View.GONE
    }

    private fun showInformation(city: City) {
        text_view_details_activity_coma.visibility = View.VISIBLE
        text_view_details_activity_celsius.visibility = View.VISIBLE
        text_view_details_activity_bar.visibility = View.VISIBLE
        text_view_details_activity_name_city.text = city.name
        text_view_details_activity_name_country.text = city.country
        text_view_details_activity_description.text = city.weather[DEFAULT_INT].description
        text_view_details_activity_temp.text = city.temp?.temp?.toInt().toString()
        text_view_details_activity_temp_min.text = city.temp?.temp_min?.toInt().toString()
        text_view_details_activity_temp_max.text = city.temp?.temp_max?.toInt().toString()
    }

    companion object {
        private const val DEFAULT_INT = 0
    }
}