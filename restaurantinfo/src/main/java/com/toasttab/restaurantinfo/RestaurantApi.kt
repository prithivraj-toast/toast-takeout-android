package com.toasttab.restaurantinfo

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantApi {
    @GET("{shortUrl}/v2/menus")
    suspend fun getRestaurantInfo(
        @Path("shortUrl") shortUrl: String,
        @Query("fulfillmentDateTime") fulfillmentDateTime: String = "2019-11-01T16:40:47Z"
    ): Response<List<RestaurantInfoModel>>

    companion object {
        private const val BASE_URL = "https://preprod.eng.toasttab.com/"
        fun create(): RestaurantApi {
            val gson = GsonBuilder().create()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RestaurantApi::class.java)
        }

        private val okHttpClient: OkHttpClient by lazy {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d("RestaurantListService", it)
            })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
        }
    }
}