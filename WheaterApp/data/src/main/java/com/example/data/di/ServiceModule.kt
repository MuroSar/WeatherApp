package com.example.data.di

import com.example.data.services.WeatherCityServiceImpl
import com.example.domain.servicies.WeatherCityService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ServiceModule {

    @Singleton
    @Provides
    fun provideWeatherCityService(): WeatherCityService = WeatherCityServiceImpl()
}