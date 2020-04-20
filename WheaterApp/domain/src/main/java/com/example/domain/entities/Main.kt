package com.example.domain.entities

import com.example.domain.utils.DEFAULT_TEMP

data class Main(
        val temp: Double = DEFAULT_TEMP,
        val temp_min: Double = DEFAULT_TEMP,
        val temp_max: Double = DEFAULT_TEMP
)