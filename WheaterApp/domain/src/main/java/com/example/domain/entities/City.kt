package com.example.domain.entities

import com.example.domain.utils.DEFAULT_ID
import com.example.domain.utils.NOT_FOUND

data class City(
        val id: Int = DEFAULT_ID,
        val name: String = NOT_FOUND,
        val country: String = NOT_FOUND,
        val weather: ArrayList<Weather> = arrayListOf(),
        val temp: Main? = Main()
)