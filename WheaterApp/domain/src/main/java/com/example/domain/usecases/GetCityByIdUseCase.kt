package com.example.domain.usecases

import com.example.domain.entities.City

interface GetCityByIdUseCase {

    operator fun invoke(listOfCity:MutableList<City>, name: String): Int
}