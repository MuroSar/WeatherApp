package com.example.domain.usecases

import com.example.domain.entities.City
import com.example.domain.utils.Result

interface GetCityByIdUseCase {

    operator fun invoke(id: Int): Result<City>
}