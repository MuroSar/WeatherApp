package com.example.domain.entities

import com.example.domain.utils.DEFAULT_ID
import com.example.domain.utils.NOT_FOUND

data class Weather(
        val id: Int = DEFAULT_ID,
        val main: String = NOT_FOUND,
        val description: String = NOT_FOUND,
        val icon: String = NOT_FOUND
)