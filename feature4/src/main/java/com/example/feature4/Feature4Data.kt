package com.example.feature4

import android.arch.lifecycle.MutableLiveData
import com.example.core_utils.default
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature4Data @Inject constructor() {
    var mainTextfeature4 = MutableLiveData<String>().default("Feature 2")
}