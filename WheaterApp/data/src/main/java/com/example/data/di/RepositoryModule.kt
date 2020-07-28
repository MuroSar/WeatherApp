package com.example.data.di

import com.example.data.repositories.CityJSONRepositoryImpl
import com.example.domain.repositories.CityJSONRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Provides
    fun provideCityJSONRepository(): CityJSONRepository = CityJSONRepositoryImpl()
}