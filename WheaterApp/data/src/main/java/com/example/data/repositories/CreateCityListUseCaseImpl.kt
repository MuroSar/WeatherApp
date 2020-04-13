package com.example.data.repositories

import com.example.data.utils.COUNTRY
import com.example.data.utils.COUNTRY_AR
import com.example.data.utils.ID
import com.example.data.utils.NAME
import com.example.domain.entities.City
import com.example.domain.usecases.CreateCityListUseCase
import org.json.JSONArray

class CreateCityListUseCaseImpl : CreateCityListUseCase {

    override fun invoke(listOfCity: MutableList<City>, jsonArray: JSONArray) {
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            if (jsonObject.get(COUNTRY).equals(COUNTRY_AR)) {
                val city = City(
                        jsonObject.get(ID).toString().toInt(),
                        jsonObject.get(NAME).toString(),
                        jsonObject.get(COUNTRY).toString()
                )
                listOfCity.add(city)
            }
        }
    }
}