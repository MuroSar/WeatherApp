package com.example.data.usecases.implementation

import com.example.data.utils.JSONData
import com.example.domain.usecases.IsNotEmptyJSON

class IsNotEmptyJSONImpl : IsNotEmptyJSON {

    override fun invoke(): Boolean {
        return JSONData.isNotEmpty()
    }
}