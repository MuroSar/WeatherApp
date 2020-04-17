package com.example.domain.services

interface WeatherCityByIdService {

    operator fun invoke(id: Int): Boolean
}