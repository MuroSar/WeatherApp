package com.example.data.services

import com.example.data.WeatherRequestGenerator
import com.example.data.WeatherRequestGenerator.Companion.API_KEY
import com.example.data.services.api.WeatherApi

class WeatherCityService {

    private val api: WeatherRequestGenerator = WeatherRequestGenerator()

    fun getWeatherOfACityById(id: Int): Boolean {
        val queryHashMap = LinkedHashMap<String, String>()
        queryHashMap.put(ID, id.toString())
        queryHashMap.put(APPID, API_KEY)
        val callResponse = api.createService(WeatherApi::class.java).getCityById(queryHashMap)
        val response = callResponse.execute()
        if (response != null) {
            return true
        }
        return false
    }

    companion object {
        private const val ID = "id"
        private const val APPID = "APPID"
    }
}