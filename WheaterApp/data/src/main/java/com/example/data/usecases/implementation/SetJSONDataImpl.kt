package com.example.data.usecases.implementation

import com.example.data.utils.JSONData
import com.example.domain.usecases.SetJSONData

class SetJSONDataImpl : SetJSONData {

    override fun invoke(listOfCities: MutableList<String>) {
        JSONData.setJSON(listOfCities)
    }
}