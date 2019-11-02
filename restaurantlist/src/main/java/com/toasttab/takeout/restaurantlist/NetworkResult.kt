package com.toasttab.takeout.restaurantlist

sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>()
    data class Error(val errorMessage: String) : NetworkResult<Nothing>()
}

sealed class ContentState<out T : Any> {
    object Loading : ContentState<Nothing>()
    data class Content<out T : Any>(val data: T) : ContentState<T>()
    data class Error(val errorMessage: String) : ContentState<Nothing>()
}