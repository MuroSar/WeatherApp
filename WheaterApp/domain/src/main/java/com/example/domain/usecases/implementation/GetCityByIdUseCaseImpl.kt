package com.example.domain.usecases.implementation

import com.example.domain.repositories.WeatherCityByIdRepository
import com.example.domain.usecases.GetCityByIdUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetCityByIdUseCaseImpl(): GetCityByIdUseCase, KoinComponent{

    private val weatherCityByIdRepository: WeatherCityByIdRepository by inject()

    override fun invoke(id: Int) = weatherCityByIdRepository.invoke(id)
}