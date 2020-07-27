package com.example.data.di

import dagger.Module

@Module(includes = [RepositoryModule::class, ServiceModule::class])
object DataModule