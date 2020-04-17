package com.example.domain.usecases.implementation

import com.example.domain.utils.ZERO
import com.example.domain.entities.City
import com.example.domain.usecases.GetCityByIdUseCase

class GetCityByIdUseCaseImpl: GetCityByIdUseCase {

    override fun invoke(listOfCity: MutableList<City>, name: String): Int {
        for (i in ZERO until listOfCity.size) {
            if (listOfCity[i].name.equals(name)) {
                return listOfCity[i].id
            }
        }
        return ZERO
    }
}