package com.example.weatherapp.contracts

interface CityContract {
    interface ViewModel {
        fun buttonDonePressed()
        fun getListOfCities()
    }

    interface View {
        fun nextActivityIntent()
        fun getCityList()
    }
}