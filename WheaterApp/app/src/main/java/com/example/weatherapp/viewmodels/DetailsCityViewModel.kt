package com.example.weatherapp.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.City
import com.example.domain.usecases.GetCityByIdUseCase
import com.example.domain.utils.Result
import com.example.weatherapp.contracts.DetailsCityContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.ERROR
import com.example.weatherapp.utils.Status.GETTING_DATA
import com.example.weatherapp.utils.Status.UPLOADED_DATA
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsCityViewModel @ViewModelInject constructor(
    private val getCityByIdUseCase: GetCityByIdUseCase
) : ViewModel(), DetailsCityContract.ViewModel {
    private val mutableMainState: MutableLiveData<Event<Data<City>>> = MutableLiveData()
    val mainState: LiveData<Event<Data<City>>>
        get() = mutableMainState

    override fun getInformationFromAPI(id: Int) = viewModelScope.launch {
        mutableMainState.postValue(Event(Data(status = GETTING_DATA)))
        withContext(Dispatchers.IO) { getCityByIdUseCase.invoke(id) }.let {
            when (it) {
                is Result.Success -> {
                    mutableMainState.postValue(Event(Data(status = UPLOADED_DATA, city = it.data)))
                }
                is Result.Failure -> {
                    mutableMainState.postValue(Event(Data(status = ERROR, error = it.exception)))
                }
            }
        }
    }
}