package com.example.domain.di

import com.example.domain.repositories.CityJSONRepository
import com.example.domain.servicies.WeatherCityService
import com.example.domain.usecases.CreateCityListUseCase
import com.example.domain.usecases.GetCityByIdUseCase
import com.example.domain.usecases.GetCityByNameUseCase
import com.example.domain.usecases.JSONDataUseCase
import com.example.domain.usecases.implementation.CreateCityListUseCaseImpl
import com.example.domain.usecases.implementation.GetCityByIdUseCaseImpl
import com.example.domain.usecases.implementation.GetCityByNameUseCaseImpl
import com.example.domain.usecases.implementation.JSONDataUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DomainModule {

    @Provides
    fun provideJsonDataUseCase(cityJSONRepository: CityJSONRepository): JSONDataUseCase = JSONDataUseCaseImpl(cityJSONRepository)

    @Provides
    fun provideGetCityByNameUseCase(): GetCityByNameUseCase = GetCityByNameUseCaseImpl()

    @Provides
    fun provideCreateCityListUseCase(): CreateCityListUseCase = CreateCityListUseCaseImpl()

    @Provides
    fun provideGetCityByIdUseCase(weatherCityService: WeatherCityService): GetCityByIdUseCase = GetCityByIdUseCaseImpl(weatherCityService)
}