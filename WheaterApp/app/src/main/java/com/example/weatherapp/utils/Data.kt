package com.example.weatherapp.utils

import com.example.domain.entities.City

data class Data<RequestData>(
        var status: Status,
        var data: RequestData? = null,
        var error: Exception? = null,
        var listOfCities: List<String> = emptyList(),
        var city: City = City()
)

enum class Status { INIT, CHARGED_JSON, DONE,
                    GETTING_DATA, UPLOADED_DATA, ERROR}

