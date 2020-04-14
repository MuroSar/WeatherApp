package com.example.weatherapp.utils

object JSONData {

    var listOfCitiesString = mutableListOf<String>()

    fun getJSON() = listOfCitiesString

    fun setJSON(list: MutableList<String>) {
        listOfCitiesString = list
    }

    fun isNotEmpty(): Boolean {
        return listOfCitiesString.isNotEmpty()
    }
}