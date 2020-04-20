package com.example.domain.servicies

import com.example.domain.entities.City
import com.example.domain.utils.Result

interface WeatherCityService {

    fun getCityById(id: Int): Result<City>
}