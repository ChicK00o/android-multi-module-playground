package com.example.feature4b

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class Feature4bActivityViewModel @Inject constructor(
    private val feature4bRepository: Feature4bRepository) : ViewModel() {

    var mainText : LiveData<String> = feature4bRepository.mainText

    fun setText(value : String) {
        feature4bRepository.mainText.value = value
    }
}