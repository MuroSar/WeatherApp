package com.example.data.mappers

import com.example.data.services.response.CityResponse
import com.example.data.services.response.MainResponse
import com.example.data.services.response.WeatherResponse
import com.example.domain.entities.City
import com.example.domain.entities.Main
import com.example.domain.entities.Weather

class WeatherCityMapperService : BaseMapperRepository<CityResponse, City> {

    override fun transform(type: CityResponse): City {
        type.apply {
            return City(
                    id,
                    name,
                    COUNTRY_AR,
                    temp = transformMain(main),
                    weather = transformWeather(weather)
            )
        }
    }

    private fun transformMain(type: MainResponse): Main {
        type.apply {
            return Main(
                    temp- DEGREE_KELVIN,
                    temp_min-DEGREE_KELVIN,
                    temp_max-DEGREE_KELVIN
            )
        }
    }

    private fun transformWeather(type: ArrayList<WeatherResponse>): ArrayList<Weather> {
        lateinit var weather: Weather
        type[ZERO].apply {
            weather = Weather(
                    id,
                    main,
                    description,
                    icon
            )
        }
        val list = arrayListOf<Weather>()
        list.add(weather)
        return list
    }

    companion object {
        private const val ZERO = 0
        private const val COUNTRY_AR = "AR"
        private const val DEGREE_KELVIN = 273
    }
}