package com.example.data.repositories

import com.example.data.utils.JSONData
import com.example.domain.repositories.CityJSONRepository
import javax.inject.Inject

class CityJSONRepositoryImpl @Inject constructor() : CityJSONRepository {
    override fun getJSONData() = JSONData.getJSON()

    override fun isNotEmptyData(): Boolean {
        return JSONData.isNotEmpty()
    }

    override fun setJSONData(listOfString: MutableList<String>) {
        JSONData.setJSON(listOfString)
    }
}