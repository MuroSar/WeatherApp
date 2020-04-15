package com.example.di

import com.example.data.usecases.implementation.GetJSONDataImpl
import com.example.data.usecases.implementation.IsNotEmptyJSONImpl
import com.example.data.usecases.implementation.SetJSONDataImpl
import com.example.domain.usecases.CreateCityListUseCase
import com.example.domain.usecases.GetCityByIdUseCase
import com.example.domain.usecases.GetJSONData
import com.example.domain.usecases.IsNotEmptyJSON
import com.example.domain.usecases.SetJSONData
import com.example.domain.usecases.implementation.CreateCityListUseCaseImpl
import com.example.domain.usecases.implementation.GetCityByIdUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    factory<GetCityByIdUseCase> { GetCityByIdUseCaseImpl() }
    factory<CreateCityListUseCase> { CreateCityListUseCaseImpl() }
    factory<GetJSONData> { GetJSONDataImpl() }
    factory<SetJSONData> { SetJSONDataImpl() }
    factory<IsNotEmptyJSON> { IsNotEmptyJSONImpl() }
}