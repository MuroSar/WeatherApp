package com.example.data.repositories

import com.example.data.services.WeatherCityService
import com.example.domain.repositories.WeatherCityByIdRepository

class WeatherCityByIdRepositoryImpl(
        private val weatherCityService: WeatherCityService
) : WeatherCityByIdRepository {

    override fun invoke(id: Int) = weatherCityService.getCityById(id)
}