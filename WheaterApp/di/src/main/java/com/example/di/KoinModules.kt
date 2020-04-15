package com.example.di

import com.example.data.usecases.implementation.JSONDataUseCaseImpl
import com.example.domain.usecases.CreateCityListUseCase
import com.example.domain.usecases.GetCityByIdUseCase
import com.example.domain.usecases.JSONDataUseCase
import com.example.domain.usecases.implementation.CreateCityListUseCaseImpl
import com.example.domain.usecases.implementation.GetCityByIdUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    factory<GetCityByIdUseCase> { GetCityByIdUseCaseImpl() }
    factory<CreateCityListUseCase> { CreateCityListUseCaseImpl() }
    factory<JSONDataUseCase> { JSONDataUseCaseImpl() }
}