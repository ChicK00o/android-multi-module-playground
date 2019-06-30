package com.example.android_playground

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(
    private val mainActivityRepository: MainActivityRepository) : ViewModel() {

    var mainText : LiveData<String> = mainActivityRepository.mainText

    fun setText(value : String) {
        mainActivityRepository.mainText.value = value
    }
}