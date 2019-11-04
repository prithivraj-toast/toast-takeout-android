package com.toasttab.restaurantinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RestaurantListRecyclerViewAdapter(private var items: List<ItemX>) :
    RecyclerView.Adapter<RestaurantListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListViewHolder =
        RestaurantListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_restaurant_info_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RestaurantListViewHolder, position: Int) {
        val item = items[position]
        Picasso.get().load(item.imageLink)
            .into(holder.itemImage)
        holder.itemPrice.text = item.price.toString()
        holder.itemName.text = item.name
        holder.itemIngredients.text = item.description
    }

    fun setData(data: List<ItemX>) {
        items = data
    }
}

class RestaurantListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemImage: ImageView = itemView.findViewById(R.id.item_image)
    val itemName: TextView = itemView.findViewById(R.id.item_name)
    val itemIngredients: TextView = itemView.findViewById(R.id.item_ingredients)
    val itemPrice: TextView = itemView.findViewById(R.id.item_price)
}