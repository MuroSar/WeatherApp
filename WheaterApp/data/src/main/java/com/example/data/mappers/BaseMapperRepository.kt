package com.example.data.mappers

interface BaseMapperRepository<E, D> {

    fun transform(type: E): D

}