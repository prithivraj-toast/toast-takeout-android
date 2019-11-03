package com.toasttab.takeout.restaurantlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_restaurant_list.*

class RestaurantListFragment : Fragment() {

    private lateinit var viewModel: RestaurantListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_restaurant_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(
            activity!!,
            RestaurantListViewModelFactory()
        )[RestaurantListViewModel::class.java]

        viewModel.viewState.observe(this, Observer {
            when (it) {
                ContentState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    restaurant_list.visibility = View.GONE
                    error_message.visibility = View.GONE
                }
                is ContentState.Content -> {
                    progressBar.visibility = View.GONE
                    restaurant_list.visibility = View.VISIBLE
                    error_message.visibility = View.GONE

                    val currentAdapter = restaurant_list.adapter
                    if (currentAdapter == null) {
                        restaurant_list.apply {
                            layoutManager = LinearLayoutManager(context)
                            adapter = RestaurantListRecyclerViewAdapter(it.data)
                        }
                    } else {
                        (currentAdapter as RestaurantListRecyclerViewAdapter).setData(it.data)
                        currentAdapter.notifyDataSetChanged()
                    }
                }
                is ContentState.Error -> {
                    progressBar.visibility = View.GONE
                    restaurant_list.visibility = View.GONE
                    error_message.visibility = View.VISIBLE
                    error_message.text = it.errorMessage
                }
            }
        })
        viewModel.onViewCreated(
            42.3600807,
            -71.0588836
        )
    }
}
