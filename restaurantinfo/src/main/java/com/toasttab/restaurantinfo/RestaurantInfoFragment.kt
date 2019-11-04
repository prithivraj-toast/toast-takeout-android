package com.toasttab.restaurantinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_restaurant_info.*

class RestaurantInfoFragment : Fragment() {

    private lateinit var viewModel: RestaurantInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val shortUrl: String = arguments!!["shortUrl"].toString()
        viewModel = ViewModelProviders.of(
            activity!!,
            RestaurantInfoViewModelFactory()
        )[RestaurantInfoViewModel::class.java]
        viewModel.viewState.observe(this, Observer {
            when (it) {
                ContentState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    restaurant_info.visibility = View.GONE
                    error_message.visibility = View.GONE
                }
                is ContentState.Content -> {
                    progressBar.visibility = View.GONE
                    restaurant_info.visibility = View.VISIBLE
                    error_message.visibility = View.GONE

                    val currentAdapter = restaurant_info.adapter
                    if (currentAdapter == null) {
                        restaurant_info.apply {
                            layoutManager = LinearLayoutManager(context)
                            val mutableList = mutableListOf<ItemX>()
                            it.data.forEach { restaurantMenuSection ->
                                restaurantMenuSection.groups.forEach { group ->
                                    mutableList.addAll(group.items)
                                }
                            }
                            adapter = RestaurantListRecyclerViewAdapter(mutableList)
                        }
                    } else {
                        val mutableList = mutableListOf<ItemX>()
                        it.data.forEach { restaurantMenuSection ->
                            restaurantMenuSection.groups.forEach { group ->
                                mutableList.addAll(group.items)
                            }
                        }
                        (currentAdapter as RestaurantListRecyclerViewAdapter).setData(mutableList)
                        currentAdapter.notifyDataSetChanged()
                    }
                }
                is ContentState.Error -> {
                    progressBar.visibility = View.GONE
                    restaurant_info.visibility = View.GONE
                    error_message.visibility = View.VISIBLE
                    error_message.text = it.errorMessage
                }
            }
        })
        viewModel.onViewCreated(shortUrl = shortUrl)
    }
}
