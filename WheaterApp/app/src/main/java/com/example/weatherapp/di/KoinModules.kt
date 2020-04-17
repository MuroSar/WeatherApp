package com.example.weatherapp.di

import com.example.weatherapp.viewmodels.CityMainViewModel
import com.example.weatherapp.viewmodels.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { CityMainViewModel(get(), get(), get()) }
    viewModel { SplashScreenViewModel(get(), get()) }
}
