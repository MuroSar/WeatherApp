package com.example.weatherapp.viewmodels

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.City
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event

class CityMainViewModel: ViewModel() {

    private val mutableMainState: MutableLiveData<Event<Data<City>>> = MutableLiveData()

    val mainState: LiveData<Event<Data<City>>>
        get() {
            return mutableMainState
        }

    fun buttonDonePressed() {
        //TODO changed live data state
    }
}