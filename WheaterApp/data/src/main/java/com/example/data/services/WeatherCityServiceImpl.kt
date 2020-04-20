package com.example.data.services

import com.example.data.WeatherRequestGenerator
import com.example.data.mappers.WeatherCityMapperService
import com.example.data.services.api.WeatherApi
import com.example.domain.entities.City
import com.example.domain.servicies.WeatherCityService
import com.example.domain.utils.Result

class WeatherCityServiceImpl : WeatherCityService {

    private val api: WeatherRequestGenerator = WeatherRequestGenerator()
    private val mapper: WeatherCityMapperService = WeatherCityMapperService()

    override fun getCityById(id: Int): Result<City> {
        val queryHashMap = LinkedHashMap<String, String>()
        queryHashMap.put(ID, id.toString())
        queryHashMap.put(APPID, WeatherRequestGenerator.API_KEY)
        val callResponse = api.createService(WeatherApi::class.java).getCityById(queryHashMap)
        val response = callResponse.execute()
        response.let { responseIt ->
            if (responseIt.isSuccessful) {
                responseIt.body()?.let { bodyIt -> mapper.transform(bodyIt) }?.let { return Result.Success(it) }
            }
            return Result.Failure(Exception(response.message()))
        }
    }

    companion object {
        private const val ID = "id"
        private const val APPID = "APPID"
    }
}