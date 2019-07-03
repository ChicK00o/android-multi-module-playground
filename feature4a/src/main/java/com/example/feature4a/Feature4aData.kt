package com.example.feature4a

import android.arch.lifecycle.MutableLiveData
import com.example.core_utils.default
import com.example.core_utils.di.PerFeature
import javax.inject.Inject
import javax.inject.Singleton

@PerFeature
class Feature4aData @Inject constructor() {
    var mainTextfeature4a = MutableLiveData<String>().default("Feature 4a")
}