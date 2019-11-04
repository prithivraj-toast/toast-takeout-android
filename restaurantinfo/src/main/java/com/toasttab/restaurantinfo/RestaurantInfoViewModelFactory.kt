package com.toasttab.restaurantinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RestaurantInfoViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantInfoViewModel::class.java)) {
            return RestaurantInfoViewModel(
                NetworkRestaurantInfoRepository(RestaurantApi.create())
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
