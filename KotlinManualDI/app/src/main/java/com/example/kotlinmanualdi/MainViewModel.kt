package com.example.kotlinmanualdi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val numberRepository: NumberRespository): ViewModel() {
    private val numberLiveData = MutableLiveData<Int>()
    fun getLiveData(): MutableLiveData<Int> = numberLiveData
    fun generateNextNumber(){
        numberLiveData.postValue(numberRepository.generateNextNumber())
    }

}