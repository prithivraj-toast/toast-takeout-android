package com.toasttab.takeout.restaurantlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RestaurantListRecyclerViewAdapter(private var items: List<RestaurantListModel>) :
    RecyclerView.Adapter<RestaurantListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListViewHolder =
        RestaurantListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_restaurant_list_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RestaurantListViewHolder, position: Int) {
        val restaurant = items[position]
        Picasso.get().load("https://s3.amazonaws.com/toasttab${restaurant.imageUrl}")
            .into(holder.restaurantImage)
        holder.restaurantName.text = restaurant.name
        holder.restaurantDistance.text = restaurant.distance.toString()
        holder.restaurantPrepTime.text = restaurant.minimumTakeoutTime.toString()
        holder.restaurantType.text = restaurant.cuisineType
    }

    fun setData(data: List<RestaurantListModel>) {
        items = data
    }
}

class RestaurantListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val restaurantImage: ImageView = itemView.findViewById(R.id.restaurant_image)
    val restaurantName: TextView = itemView.findViewById(R.id.restaurant_name)
    val restaurantDistance: TextView = itemView.findViewById(R.id.restaurant_distance)
    val restaurantPrepTime: TextView = itemView.findViewById(R.id.restaurant_preptime)
    val restaurantType: TextView = itemView.findViewById(R.id.restaurant_type)
}
