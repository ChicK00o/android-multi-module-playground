package com.example.feature2

import android.arch.lifecycle.MutableLiveData
import com.example.core_utils.default
import com.example.core_utils.di.AppScope
import javax.inject.Inject

@AppScope
class Feature2Data @Inject constructor() {
    var mainTextFeature2 = MutableLiveData<String>().default("Feature 2")
}