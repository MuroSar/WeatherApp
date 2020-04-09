package com.example.weatherapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.City
import com.example.weatherapp.activities.CityMainActivity.Companion.COUNTRY
import com.example.weatherapp.activities.CityMainActivity.Companion.COUNTRY_AR
import com.example.weatherapp.activities.CityMainActivity.Companion.ID
import com.example.weatherapp.activities.CityMainActivity.Companion.NAME
import com.example.weatherapp.activities.CityMainActivity.Companion.listOfCity
import com.example.weatherapp.activities.CityMainActivity.Companion.listOfNameOfCity
import com.example.weatherapp.contracts.CityContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.BEFORE
import com.example.weatherapp.utils.Status.DONE
import org.json.JSONArray

open class CityMainViewModel : ViewModel(), CityContract.ViewModel {

    private val mutableMainState: MutableLiveData<Event<Data<City>>> = MutableLiveData()

    val mainState: LiveData<Event<Data<City>>>
        get() {
            return mutableMainState
        }

    override fun buttonDonePressed() {
        mutableMainState.postValue(Event(Data(status = DONE)))
    }

    override fun initAutoCompleteTextViewState() {
        mutableMainState.postValue(Event(Data(status = BEFORE)))
    }

    override fun createCityList(jsonArray: JSONArray) {
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)

            if (jsonObject.get(COUNTRY).equals(COUNTRY_AR)) {
                val city = City(
                        jsonObject.get(ID).toString().toInt(),
                        jsonObject.get(NAME).toString(),
                        jsonObject.get(COUNTRY).toString()
                )
                listOfCity.add(city)
                listOfNameOfCity.add(city.name)
            }
        }
    }

    fun getCityId(name: String): Int {
        for (i in ZERO until listOfCity.size) {
            if (listOfCity[i].name.equals(name)) {
                return listOfCity[i].id
            }
        }
        return ZERO
    }

    companion object {
        private const val ZERO = 0
    }
}