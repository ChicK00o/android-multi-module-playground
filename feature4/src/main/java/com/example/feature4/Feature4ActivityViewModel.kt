package com.example.feature4

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class Feature4ActivityViewModel @Inject constructor(
    private val feature4Repository: Feature4Repository) : ViewModel() {

    var mainText : LiveData<String> = feature4Repository.mainText

    fun setText(value : String) {
        feature4Repository.mainText.value = value
    }
}