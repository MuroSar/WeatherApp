package com.example.weatherapp.utils

data class Data<RequestData>(
        var status: Status,
        var data: RequestData? = null,
        var error: Exception? = null,
        var listOfCities: List<String> = emptyList()
)

enum class Status { INIT, CHARGED_JSON, DONE }

