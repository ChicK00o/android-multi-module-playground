package com.example.feature3

import android.arch.lifecycle.MutableLiveData
import com.example.core_utils.default
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature3Data @Inject constructor() {
    var mainTextfeature3 = MutableLiveData<String>().default("Feature 2")
}