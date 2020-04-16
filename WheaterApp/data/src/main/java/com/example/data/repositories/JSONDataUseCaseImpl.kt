package com.example.data.usecases.implementation

import com.example.data.utils.JSONData
import com.example.domain.usecases.JSONDataUseCase

class JSONDataUseCaseImpl: JSONDataUseCase {

    override fun getJSONData() = JSONData.getJSON()

    override fun isNotEmptyData(): Boolean {
        return JSONData.isNotEmpty()
    }

    override fun setJSONData(listOfString: MutableList<String>) {
        JSONData.setJSON(listOfString)
    }
}