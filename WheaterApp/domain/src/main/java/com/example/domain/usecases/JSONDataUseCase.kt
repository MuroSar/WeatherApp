package com.example.domain.usecases

interface JSONDataUseCase {

    fun isNotEmptyData(): Boolean

    fun getJSONData(): MutableList<String>

    fun setJSONData(listOfString: MutableList<String>)
}