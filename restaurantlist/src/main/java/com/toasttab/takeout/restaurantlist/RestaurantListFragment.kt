package com.toasttab.takeout.restaurantlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class RestaurantListFragment : Fragment() {

    lateinit var viewModel: RestaurantListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_restaurant_list_item, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(
            activity!!,
            RestaurantListViewModelFactory()
        )[RestaurantListViewModel::class.java]

        viewModel.viewState.observe(this, Observer {
            Log.d("test", it.toString())
        })
        viewModel.onViewCreated(
            42.3600807,
            -71.0588836
        )
    }
}
