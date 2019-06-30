package com.example.feature2

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class Feature2ActivityViewModel @Inject constructor(
    private val feature2Repository: Feature2Repository) : ViewModel() {

    var mainText : LiveData<String> = feature2Repository.mainText

    fun setText(value : String) {
        feature2Repository.mainText.value = value
    }
}