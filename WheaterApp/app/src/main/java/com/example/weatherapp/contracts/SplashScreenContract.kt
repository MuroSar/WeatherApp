package com.example.weatherapp.contracts

import kotlinx.coroutines.Job

interface SplashScreenContract {
    interface ViewModel {
        fun initJSON()
        fun createCityList(JSON: String): Job
    }
}