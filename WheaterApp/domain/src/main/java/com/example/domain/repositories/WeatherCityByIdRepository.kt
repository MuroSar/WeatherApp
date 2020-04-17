package com.example.domain.repositories

interface WeatherCityByIdRepository {

    operator fun invoke(id: Int): Boolean
}