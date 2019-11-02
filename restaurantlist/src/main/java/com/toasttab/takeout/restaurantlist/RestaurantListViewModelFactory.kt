package com.toasttab.takeout.restaurantlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RestaurantListViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantListViewModel::class.java)) {
            return RestaurantListViewModel(
                NetworkRestaurantListRepository(RestaurantListApi.create())
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
