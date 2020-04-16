package com.example.data.repositories

import com.example.data.services.WeatherCityService
import com.example.domain.usecases.GetCityByIdUseCase

class GetCityByIdUseCaseImpl(private val weatherCityService: WeatherCityService): GetCityByIdUseCase{

    override fun invoke(id: Int): Boolean {
        return weatherCityService.getWeatherOfACityById(id)
    }
}