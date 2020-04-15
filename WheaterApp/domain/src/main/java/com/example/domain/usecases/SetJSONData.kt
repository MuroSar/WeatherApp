package com.example.domain.usecases

interface SetJSONData {

    operator fun invoke(listOfCities: MutableList<String>)
}