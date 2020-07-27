package com.example.weatherapp.di

import com.example.data.di.DataModule
import com.example.domain.di.DomainModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module(includes = [DataModule::class, DomainModule::class])
object AppModule