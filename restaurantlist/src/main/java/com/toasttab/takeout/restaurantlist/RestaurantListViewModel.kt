package com.toasttab.takeout.restaurantlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RestaurantListViewModel(private val repository: RestaurantListRepository) : ViewModel() {

    private val _viewState = MutableLiveData<ContentState<List<RestaurantListModel>>>()

    val viewState: LiveData<ContentState<List<RestaurantListModel>>> = _viewState

    fun onViewCreated(
        latitude: Double,
        longitude: Double
    ) {
        viewModelScope.launch {
            _viewState.postValue(ContentState.Loading)
            val restaurantList = repository.getRestaurantList(
                latitude = latitude,
                longitude = longitude
            )
            when (restaurantList) {
                is NetworkResult.Success -> {
                    val data = restaurantList.data
                    _viewState.postValue(ContentState.Content(data))
                }
                is NetworkResult.Error -> {
                    _viewState.postValue(ContentState.Error(restaurantList.errorMessage))
                }
            }
        }
    }
}