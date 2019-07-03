package com.example.feature4

import com.example.core_utils.di.FeatureScope
import com.example.feature4scope.iFeature4ScopedData
import javax.inject.Inject

@FeatureScope
class Feature4ScopedDataImpl @Inject constructor() : iFeature4ScopedData {
    override fun getStringValue(): String {
        return "Feature 4 is Implementing this"
    }
}