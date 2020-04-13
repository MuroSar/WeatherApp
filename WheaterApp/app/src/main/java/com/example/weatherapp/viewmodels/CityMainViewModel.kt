package com.example.weatherapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.City
import com.example.domain.usecases.CreateCityListUseCase
import com.example.domain.usecases.GetCityByIdUseCase
import com.example.weatherapp.contracts.CityContract
import com.example.weatherapp.utils.Data
import com.example.weatherapp.utils.Event
import com.example.weatherapp.utils.Status.DONE
import com.example.weatherapp.utils.Status.INIT
import org.json.JSONArray

class CityMainViewModel(
        private val getCityByIdUseCase: GetCityByIdUseCase,
        private val createCityListIdUseCase: CreateCityListUseCase
) : ViewModel(), CityContract.ViewModel {

    private val mutableMainState: MutableLiveData<Event<Data<City>>> = MutableLiveData()

    val mainState: LiveData<Event<Data<City>>>
        get() {
            return mutableMainState
        }

    override fun buttonDonePressed() {
        mutableMainState.postValue(Event(Data(status = DONE)))
    }

    override fun initAutoCompleteTextViewState() {
        mutableMainState.postValue(Event(Data(status = INIT)))
    }

    override fun createCityList(jsonArray: JSONArray): MutableList<String> {
        val stringList = mutableListOf<String>()
        createCityListIdUseCase.invoke(listOfCity, jsonArray)
        for (i in 0 until listOfCity.size) {
            stringList.add(listOfCity[i].name)
        }
        return stringList
    }

    fun getCityId(name: String): Int = getCityByIdUseCase.invoke(listOfCity, name)

    companion object {
        private var listOfCity = mutableListOf<City>()
        const val NAME = "name"
    }
}