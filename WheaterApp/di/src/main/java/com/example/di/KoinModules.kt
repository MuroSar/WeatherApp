package com.example.di

import com.example.data.services.WeatherCityService
import com.example.data.usecases.implementation.GetCityByIdUseCaseImpl
import com.example.data.usecases.implementation.JSONDataUseCaseImpl
import com.example.domain.usecases.CreateCityListUseCase
import com.example.domain.usecases.GetCityByIdUseCase
import com.example.domain.usecases.GetCityByNameUseCase
import com.example.domain.usecases.JSONDataUseCase
import com.example.domain.usecases.implementation.CreateCityListUseCaseImpl
import com.example.domain.usecases.implementation.GetCityByNameUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    single { WeatherCityService() }
    factory<GetCityByNameUseCase> { GetCityByNameUseCaseImpl() }
    factory<CreateCityListUseCase> { CreateCityListUseCaseImpl() }
    factory<JSONDataUseCase> { JSONDataUseCaseImpl() }
    factory<GetCityByIdUseCase> { GetCityByIdUseCaseImpl(get()) }
}