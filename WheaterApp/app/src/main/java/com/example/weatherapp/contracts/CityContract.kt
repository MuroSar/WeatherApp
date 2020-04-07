package com.example.weatherapp.contracts

interface CityContract {
    interface ViewModel {
        fun buttonDonePressed()
    }

    interface View {
        fun nextActivityIntent()
        fun getCityList()
    }
}