package com.example.domain.usecases.implementation

import com.example.domain.services.WeatherCityByIdService
import com.example.domain.usecases.GetCityByIdUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetCityByIdUseCaseImpl(): GetCityByIdUseCase, KoinComponent{

    private val weatherCityByIdService: WeatherCityByIdService by inject()

    override fun invoke(id: Int) = weatherCityByIdService.invoke(id)
}