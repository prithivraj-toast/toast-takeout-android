package com.toasttab.takeout.restaurantlist

import com.google.gson.annotations.SerializedName

data class RestaurantListModel(
    @SerializedName("address")
    val address: Address,
    @SerializedName("closed")
    val closed: Boolean, // false
    @SerializedName("cuisineType")
    val cuisineType: String, // Italian
    @SerializedName("distance")
    val distance: Double, // 8.743896057483857
    @SerializedName("guid")
    val guid: String, // 09b7046b-d55d-48d5-be56-6e45d6d0e512
    @SerializedName("imageUrl")
    val imageUrl: String, // /restaurants/restaurant-10918000000000000/restaurant_list_image_1556550430.jpg
    @SerializedName("minimumTakeoutTime")
    val minimumTakeoutTime: Int, // 20
    @SerializedName("name")
    val name: String, // Prince Restaurant - Saugus
    @SerializedName("shortUrl")
    val shortUrl: String // prince-pizzeria
)

data class Address(
    @SerializedName("address1")
    val address1: String, // 517 Broadway
    @SerializedName("address2")
    val address2: String,
    @SerializedName("city")
    val city: String, // Saugus
    @SerializedName("country")
    val country: String, // US
    @SerializedName("latitude")
    val latitude: Double, // 42.4833863
    @SerializedName("longitude")
    val longitude: Double, // -71.02030119999999
    @SerializedName("phone")
    val phone: String, // 7812339950
    @SerializedName("state")
    val state: String, // MA
    @SerializedName("zip")
    val zip: String // 01906
)