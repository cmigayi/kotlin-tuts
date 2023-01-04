package com.example.tvguide

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tvguide.model.TVShow

class TVShowRepository(private var televisionService: TelevisionService) {
    private val apiKey = "5fc17697797b23a50431f88e3634466f"
    private val tvShowLiveData = MutableLiveData<List<TVShow>>()
    private val errorLiveData = MutableLiveData<String>()
    val tvShows: LiveData<List<TVShow>> get() = tvShowLiveData
    val error: LiveData<String> get() = errorLiveData

    suspend fun fetchTVShows() {
        try {
            val tvShows = televisionService.getTVShows(apiKey)
            tvShowLiveData.postValue(tvShows.results)
        } catch (exception: Exception) {
            errorLiveData.postValue("An error occurred:${exception.message}")
        }
    }
}