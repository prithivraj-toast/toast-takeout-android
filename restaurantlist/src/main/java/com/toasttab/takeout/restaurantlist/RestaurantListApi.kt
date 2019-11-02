package com.toasttab.takeout.restaurantlist

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantListApi {
    @GET("online-ordering/v1/restaurants/")
    suspend fun getRestaurantList(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("fulfillmentDateTime") fulfillmentDateTime: String = "2019-11-01T16:40:47Z",
        @Query("diningOption") diningOption: String = "TAKE_OUT"
    ): Response<List<RestaurantListModel>>

    companion object {
        private const val BASE_URL = "https://ws-preprod-api.eng.toasttab.com/"
        fun create(): RestaurantListApi {
            val gson = GsonBuilder().create()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RestaurantListApi::class.java)
        }

        private val okHttpClient: OkHttpClient by lazy {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.e("RestaurantListService", it)
            })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
        }
    }
}