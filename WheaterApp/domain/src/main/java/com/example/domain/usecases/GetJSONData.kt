package com.example.domain.usecases

interface GetJSONData {

    operator fun invoke(): MutableList<String>
}