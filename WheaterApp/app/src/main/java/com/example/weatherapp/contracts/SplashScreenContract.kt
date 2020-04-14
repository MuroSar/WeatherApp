package com.example.weatherapp.contracts

import androidx.lifecycle.LiveData
import com.example.domain.entities.City
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import kotlinx.coroutines.Job

interface SplashScreenContract {
    interface ViewModel {
        val mainState: LiveData<Event<Data<City>>>

        fun initJSON()
        fun createCityList(JSON: String): Job
    }
}