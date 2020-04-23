package com.example.weatherapp.contracts

import kotlinx.coroutines.Job

interface DetailsCityContract {
    interface ViewModel {
        fun getInformationFromAPI(id: Int): Job
    }
}