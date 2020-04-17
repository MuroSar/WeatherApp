package com.example.data.repositories

import com.example.data.services.WeatherCityService
import com.example.domain.services.WeatherCityByIdService

class WeatherCityByIdServiceImpl(
        private val weatherCityService: WeatherCityService
) : WeatherCityByIdService {

    override fun invoke(id: Int) = weatherCityService.getCityById(id)
}