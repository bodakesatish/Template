package com.bodakesatish.data.utils

sealed class AppResponse<out T> {
    data class Success<out T>(val data: T) : AppResponse<T>()
    data class Error(val message: String) : AppResponse<Nothing>()
    data object Loading : AppResponse<Nothing>()
}