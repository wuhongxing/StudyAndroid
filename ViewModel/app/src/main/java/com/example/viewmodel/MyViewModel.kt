package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private var LikedNumber: MutableLiveData<Int>

    init {
        LikedNumber = MutableLiveData<Int>()
        LikedNumber.value = 0
    }

    fun getLikedNumber(): MutableLiveData<Int> {
        return LikedNumber
    }

    fun addLikedNumber(n: Int) {
        LikedNumber.value = LikedNumber.value?.plus(n)
    }
}