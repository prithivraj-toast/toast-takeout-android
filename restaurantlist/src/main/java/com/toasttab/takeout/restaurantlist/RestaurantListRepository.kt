package com.toasttab.takeout.restaurantlist

interface RestaurantListRepository {
    suspend fun getRestaurantList(
        latitude: Double,
        longitude: Double
    ): NetworkResult<List<RestaurantListModel>>
}