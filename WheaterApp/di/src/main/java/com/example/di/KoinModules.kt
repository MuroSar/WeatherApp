package com.example.di

import com.example.data.repositories.CityJSONRepositoryImpl
import com.example.data.repositories.WeatherCityByIdRepositoryImpl
import com.example.data.services.WeatherCityService
import com.example.domain.usecases.implementation.JSONDataUseCaseImpl
import com.example.domain.repositories.CityJSONRepository
import com.example.domain.repositories.WeatherCityByIdRepository
import com.example.domain.usecases.CreateCityListUseCase
import com.example.domain.usecases.GetCityByIdUseCase
import com.example.domain.usecases.GetCityByNameUseCase
import com.example.domain.usecases.JSONDataUseCase
import com.example.domain.usecases.implementation.CreateCityListUseCaseImpl
import com.example.domain.usecases.implementation.GetCityByIdUseCaseImpl
import com.example.domain.usecases.implementation.GetCityByNameUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    factory<GetCityByNameUseCase> { GetCityByNameUseCaseImpl() }
    factory<CreateCityListUseCase> { CreateCityListUseCaseImpl() }
    factory<JSONDataUseCase> { JSONDataUseCaseImpl() }
    factory<GetCityByIdUseCase> { GetCityByIdUseCaseImpl() }
}

val repositoriesModule = module {
    single { WeatherCityService() }
    factory<WeatherCityByIdRepository> { WeatherCityByIdRepositoryImpl(get()) }
    factory<CityJSONRepository> { CityJSONRepositoryImpl() }
}