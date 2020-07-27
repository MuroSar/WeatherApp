package com.example.domain.usecases.implementation

import com.example.domain.entities.City
import com.example.domain.usecases.CreateCityListUseCase
import com.example.domain.utils.COUNTRY
import com.example.domain.utils.COUNTRY_AR
import com.example.domain.utils.ID
import com.example.domain.utils.NAME
import org.json.JSONArray
import javax.inject.Inject

class CreateCityListUseCaseImpl @Inject constructor() : CreateCityListUseCase {

    override fun invoke(listOfCity: MutableList<City>, jsonArray: JSONArray): MutableList<String> {
        val stringList = mutableListOf<String>()
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            if (jsonObject.get(COUNTRY).equals(COUNTRY_AR)) {
                val city = City(
                    jsonObject.get(ID).toString().toInt(),
                    jsonObject.get(NAME).toString(),
                    jsonObject.get(COUNTRY).toString()
                )
                stringList.add(city.name)
                listOfCity.add(city)
            }
        }
        return stringList
    }
}