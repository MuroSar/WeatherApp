package com.example.weatherapp.utils

data class Data<RequestData>(var status: Status, var data: RequestData? = null, var error: Exception? = null)

enum class Status {
    BEFORE,
    DONE,
    //this three status are gonna be used when
    //I do the call to the API
    SUCCESSFUL,
    ERROR,
    LOADING
}
