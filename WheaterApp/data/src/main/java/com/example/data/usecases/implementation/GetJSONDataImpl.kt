package com.example.data.usecases.implementation

import com.example.data.utils.JSONData
import com.example.domain.usecases.GetJSONData

class GetJSONDataImpl : GetJSONData {

    override fun invoke() = JSONData.getJSON()
}