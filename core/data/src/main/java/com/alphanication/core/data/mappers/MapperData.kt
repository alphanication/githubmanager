package com.alphanication.core.data.mappers

interface MapperData<E, D> {

    fun mapFromEntity(type: E): D
}

//sealed interface MapResult<E> {
//
//    data class NullPointerException(val exception: Exception)
//    data class Data<E>(val data: E)
//}