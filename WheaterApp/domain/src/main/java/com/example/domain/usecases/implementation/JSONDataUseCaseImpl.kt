package com.example.domain.usecases.implementation

import com.example.domain.repositories.CityJSONRepository
import com.example.domain.usecases.JSONDataUseCase
import javax.inject.Inject

class JSONDataUseCaseImpl @Inject constructor(private val cityJSONRepository: CityJSONRepository) : JSONDataUseCase {
    override fun getJSONData() = cityJSONRepository.getJSONData()
    override fun isNotEmptyData() = cityJSONRepository.isNotEmptyData()
    override fun setJSONData(listOfString: MutableList<String>) {
        cityJSONRepository.setJSONData(listOfString)
    }
}