package com.example.weatherapp.contracts

import org.json.JSONArray

interface CityContract {
    interface ViewModel {
        fun buttonDonePressed()
        fun initAutoCompleteTextViewState()
        fun createCityList(jsonArray: JSONArray): MutableList<String>
        fun getCityId(name: String): Int
    }

    interface View {
        fun nextActivityIntent()
        fun readJSONFile()
    }
}