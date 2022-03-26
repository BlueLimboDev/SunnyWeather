package com.example.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place

class PlaceViewModel:ViewModel() {
    /**
     * 城市搜索数据
     */
    private val searchLiveData = MutableLiveData<String>()
    /**
     * 存储已经获取到的城市
     */
    val placeList = ArrayList<Place>()

    /**
     * 网络请求成功后，数据发生变化，进而通知观察者进行数据刷新
     */
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }
    /**
     * 改变搜索城市，进而发起网络请求，详见@link{PlaceViewModel#placeLiveData}
     */
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)
    fun getSavedPlace() = Repository.getSavedPlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()
}