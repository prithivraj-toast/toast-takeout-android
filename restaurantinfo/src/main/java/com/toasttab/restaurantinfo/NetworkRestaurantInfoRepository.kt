package com.toasttab.restaurantinfo

class NetworkRestaurantInfoRepository(private val restaurantApi: RestaurantApi) :
    RestaurantInfoRepository {

    override suspend fun getRestaurantInfo(shortUrl: String): NetworkResult<List<RestaurantInfoModel>> {
        val restaurantInfoResponse = restaurantApi.getRestaurantInfo(
            shortUrl = shortUrl
        )
        val body = restaurantInfoResponse.body()

        if (restaurantInfoResponse.isSuccessful) {
            return if (body == null) {
                NetworkResult.Error("Body is null")
            } else {
                NetworkResult.Success(body)
            }
        }
        return NetworkResult.Error(restaurantInfoResponse.toString())
    }
}