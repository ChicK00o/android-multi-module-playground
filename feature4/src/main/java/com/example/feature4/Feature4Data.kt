package com.example.feature4

import android.arch.lifecycle.MutableLiveData
import com.example.core_utils.default
import com.example.core_utils.di.AppScope
import javax.inject.Inject

@AppScope
class Feature4Data @Inject constructor() {
    var mainTextfeature4 = MutableLiveData<String>().default("Feature 2")
}