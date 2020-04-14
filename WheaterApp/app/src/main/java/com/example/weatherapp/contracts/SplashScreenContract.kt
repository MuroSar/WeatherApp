package com.example.weatherapp.contracts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entities.City
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import kotlinx.coroutines.Job

interface SplashScreenContract {
    interface ViewModel {
        val mutableMainState: MutableLiveData<Event<Data<City>>>
        val mainState: LiveData<Event<Data<City>>>

        fun initAutoCompleteTextViewState()
        fun createCityList(JSON: String): Job
    }

    interface View {
        fun nextActivity()
    }
}