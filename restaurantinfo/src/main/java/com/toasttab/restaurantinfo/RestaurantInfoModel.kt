package com.toasttab.restaurantinfo

import com.google.gson.annotations.SerializedName

data class RestaurantInfoModel(
    @SerializedName("daysAvailableString")
    val daysAvailableString: List<String>,
    @SerializedName("description")
    val description: String,
    @SerializedName("endTimeHHmm")
    val endTimeHHmm: String, // 22:00
    @SerializedName("endTimeHHmmLocalStandardTime")
    val endTimeHHmmLocalStandardTime: String, // 17:00
    @SerializedName("endTimeLocalStandardTime")
    val endTimeLocalStandardTime: Int, // 61200000
    @SerializedName("groups")
    val groups: List<Group>,
    @SerializedName("id")
    val id: Long, // 5740003824968786
    @SerializedName("idString")
    val idString: String, // 5740003824968786
    @SerializedName("name")
    val name: String, // retail
    @SerializedName("orderableOnlineStatus")
    val orderableOnlineStatus: String, // YES
    @SerializedName("startTimeHHmm")
    val startTimeHHmm: String, // 16:00
    @SerializedName("startTimeHHmmLocalStandardTime")
    val startTimeHHmmLocalStandardTime: String, // 11:00
    @SerializedName("startTimeLocalStandardTime")
    val startTimeLocalStandardTime: Int // 39600000
)

data class Group(
    @SerializedName("description")
    val description: String, // PLEASE CHECK IN AT REGISTER FOR YOUR ORDER.
    @SerializedName("guid")
    val guid: String, // 36e3b6f8-b0ef-4d46-9e3e-2265bf3453c5
    @SerializedName("id")
    val id: Long, // 5740003824970094
    @SerializedName("idString")
    val idString: String, // 5740003824970094
    @SerializedName("imageLink")
    val imageLink: String, // https://s3.amazonaws.com/toasttab/restaurants/restaurant-3296000000000000/menu/images/item-3967289d-a26f-4497-bc9e-0d7098915f8a.jpg
    @SerializedName("images")
    val images: Images,
    @SerializedName("items")
    val items: List<ItemX>,
    @SerializedName("name")
    val name: String, // cookbooks - signed by Joanne!
    @SerializedName("orderableOnline")
    val orderableOnline: String, // YES
    @SerializedName("subgroups")
    val subgroups: List<Any>,
    @SerializedName("visibility")
    val visibility: String // ALL
)

data class Images(
    @SerializedName("item")
    val item: Item
)

data class Item(
    @SerializedName("fullPath")
    val fullPath: String // https://s3.amazonaws.com/toasttab/restaurants/restaurant-3296000000000000/menu/images/item-3967289d-a26f-4497-bc9e-0d7098915f8a.jpg
)

data class ItemX(
    @SerializedName("description")
    val description: String, // All 3 Flour Cookbooks! Flour, Flour, Too, and Baking With Less Sugar.
    @SerializedName("guid")
    val guid: String, // 427fa3c7-69d4-417a-b125-a9974d1bd6ad
    @SerializedName("id")
    val id: Long, // 5740003824970914
    @SerializedName("idString")
    val idString: String, // 5740003824970914
    @SerializedName("imageLink")
    val imageLink: String, // https://s3.amazonaws.com/toasttab/restaurants/restaurant-3296000000000000/menu/images/item-1a8881ec-eaaa-456c-bf2b-a8d07019f819.jpg
    @SerializedName("images")
    val images: ImagesX,
    @SerializedName("name")
    val name: String, // Flour Cookbook Power Pack
    @SerializedName("orderableOnline")
    val orderableOnline: String, // YES
    @SerializedName("price")
    val price: Double, // 85.0
    @SerializedName("prices")
    val prices: List<Any>,
    @SerializedName("unitOfMeasure")
    val unitOfMeasure: String, // NONE
    @SerializedName("visibility")
    val visibility: String // ALL
)

data class ImagesX(
    @SerializedName("item")
    val item: ItemXX
)

data class ItemXX(
    @SerializedName("fullPath")
    val fullPath: String // https://s3.amazonaws.com/toasttab/restaurants/restaurant-3296000000000000/menu/images/item-1a8881ec-eaaa-456c-bf2b-a8d07019f819.jpg
)