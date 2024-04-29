package com.alphanication.core.data.model

import java.io.IOException

enum class Status {
    SUCCESS,
    ERROR
}

data class ResultModel<out T>(
    val status: Status,
    val data: T?,
    val errorThrowable: Throwable? = null
) {
    companion object {
        fun <T> success(data: T? = null): ResultModel<T> =
            ResultModel(Status.SUCCESS, data)

        fun <T> error(errorModel: Throwable, data: T? = null): ResultModel<T> =
            ResultModel(Status.ERROR, data, errorModel)
    }
}

class AnotherError(
    val messageError: String,
    val statusCode: Int? = null,
    val errorCode: Int? = null
) : IOException()