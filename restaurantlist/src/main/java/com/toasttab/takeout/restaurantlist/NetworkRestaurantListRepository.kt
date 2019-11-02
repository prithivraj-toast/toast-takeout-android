package com.toasttab.takeout.restaurantlist

class NetworkRestaurantListRepository(private val restaurantListApi: RestaurantListApi) :
    RestaurantListRepository {
    override suspend fun getRestaurantList(
        latitude: Double,
        longitude: Double
    ): NetworkResult<List<RestaurantListModel>> {
        val restaurantListResponse = restaurantListApi.getRestaurantList(
            latitude,
            longitude
        )
        val body = restaurantListResponse.body()

        if (restaurantListResponse.isSuccessful) {
            return if (body == null) {
                NetworkResult.Error("Body is null")
            } else {
                NetworkResult.Success(body)
            }
        }
        return NetworkResult.Error(restaurantListResponse.toString())
    }
}