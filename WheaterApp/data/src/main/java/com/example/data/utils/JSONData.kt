package com.example.data.utils

object JSONData {

    private var listOfCitiesString = mutableListOf<String>()

    fun getJSON() = listOfCitiesString

    fun setJSON(list: MutableList<String>) {
        listOfCitiesString = list
    }

    fun isNotEmpty(): Boolean {
        return listOfCitiesString.isNotEmpty()
    }
}