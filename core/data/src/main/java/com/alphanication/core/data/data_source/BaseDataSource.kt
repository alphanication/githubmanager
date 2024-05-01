package com.alphanication.core.data.data_source

import com.alphanication.core.domain.model.AnotherError
import com.alphanication.core.domain.model.ResultModel
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import retrofit2.HttpException
import retrofit2.Response

private const val ERROR = "error"

abstract class BaseDataSource {

    protected suspend fun <T> invokeRequest(request: suspend () -> Response<T>): ResultModel<T> {
        return try {
            val response = request()
            when {
                response.isSuccessful -> ResultModel.success(response.body())
                else -> {
                    val errorBodyJson = response.errorBody()?.string()
                    val errorCodeModel: ErrorCodeModel? = kotlin.runCatching {
                        Gson().fromJson(errorBodyJson, ErrorCodeModel::class.java)
                    }.getOrNull()
                    ResultModel.error(
                        AnotherError(
                            response.message(),
                            response.code(),
                            errorCodeModel?.errorCode
                        )
                    )
                }
            }
        } catch (httpException: HttpException) {
            ResultModel.error(httpException)
        } catch (exception: Exception) {
            ResultModel.error(exception)
        }
    }
}

data class ErrorCodeModel(
    @SerializedName(ERROR)
    val errorCode: Int?
)