package com.example.weatherapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.City
import com.example.domain.usecases.GetCityByIdUseCase
import com.example.domain.usecases.JSONDataUseCase
import com.example.weatherapp.contracts.CityContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.DONE
import com.example.weatherapp.utils.Status.INIT

class CityMainViewModel(
        private val getCityByIdUseCase: GetCityByIdUseCase,
        private val JSONDataUseCase: JSONDataUseCase
) : ViewModel(), CityContract.ViewModel {

    private val mutableMainState: MutableLiveData<Event<Data<City>>> = MutableLiveData()

    val mainState: LiveData<Event<Data<City>>>
        get() {
            return mutableMainState
        }

    override fun buttonDonePressed() {
        mutableMainState.value = Event(Data(status = DONE))
    }

    override fun initAutoCompleteTextViewState() {
        mutableMainState.value = Event(Data(status = INIT, listOfCities = JSONDataUseCase.getJSONData()))
    }

    override fun getCityId(name: String): Int = getCityByIdUseCase(listOfCity, name)

    companion object {
        var listOfCity = mutableListOf<City>()
        const val NAME = "name"
    }
}