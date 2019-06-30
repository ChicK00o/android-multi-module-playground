package com.example.feature3

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class Feature3ActivityViewModel @Inject constructor(
    private val feature3Repository: Feature3Repository) : ViewModel() {

    var mainText : LiveData<String> = feature3Repository.mainText

    fun setText(value : String) {
        feature3Repository.mainText.value = value
    }
}