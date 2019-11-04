package com.toasttab.restaurantinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RestaurantInfoViewModel(private val repository: RestaurantInfoRepository) : ViewModel() {

    private val _viewState = MutableLiveData<ContentState<List<RestaurantInfoModel>>>()

    val viewState: LiveData<ContentState<List<RestaurantInfoModel>>> = _viewState

    fun onViewCreated(
        shortUrl: String
    ) {
        viewModelScope.launch {
            _viewState.postValue(ContentState.Loading)
            val restaurantList = repository.getRestaurantInfo(
                shortUrl
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