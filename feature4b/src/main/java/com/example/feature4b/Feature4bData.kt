package com.example.feature4b

import android.arch.lifecycle.MutableLiveData
import com.example.core_utils.default
import com.example.core_utils.di.FeatureScope
import javax.inject.Inject

@FeatureScope
class Feature4bData @Inject constructor() {
    var mainTextfeature4b = MutableLiveData<String>().default("Feature 2")
}