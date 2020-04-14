package com.example.weatherapp.contracts

interface CityContract {
    interface ViewModel {
        fun buttonDonePressed()
        fun initAutoCompleteTextViewState()
        fun getCityId(name: String): Int
    }
}