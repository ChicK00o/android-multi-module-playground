package com.example.feature4a

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class Feature4aActivityViewModel @Inject constructor(
    private val feature4aRepository: Feature4aRepository) : ViewModel() {

    var mainText : LiveData<String> = feature4aRepository.mainText

    fun setText(value : String) {
        feature4aRepository.mainText.value = value
    }
}