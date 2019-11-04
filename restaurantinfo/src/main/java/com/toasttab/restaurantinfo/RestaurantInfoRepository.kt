package com.toasttab.restaurantinfo

interface RestaurantInfoRepository {
    suspend fun getRestaurantInfo(
        shortUrl: String
    ): NetworkResult<List<RestaurantInfoModel>>
}