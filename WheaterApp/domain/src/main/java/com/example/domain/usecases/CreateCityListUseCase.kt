package com.example.domain.usecases

import com.example.domain.entities.City
import org.json.JSONArray

interface CreateCityListUseCase {

    operator fun invoke(listOfCity: MutableList<City>, jsonArray: JSONArray)
}