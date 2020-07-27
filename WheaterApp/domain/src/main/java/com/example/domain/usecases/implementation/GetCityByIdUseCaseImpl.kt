package com.example.domain.usecases.implementation

import com.example.domain.servicies.WeatherCityService
import com.example.domain.usecases.GetCityByIdUseCase
import javax.inject.Inject

class GetCityByIdUseCaseImpl @Inject constructor(private val weatherCityService: WeatherCityService) : GetCityByIdUseCase {
    override fun invoke(id: Int) = weatherCityService.getCityById(id)
}