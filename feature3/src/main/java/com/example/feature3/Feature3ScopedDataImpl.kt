package com.example.feature3

import com.example.core_utils.di.PerActivity
import com.example.core_utils.di.PerFeature
import com.example.feature4scope.iFeature4ScopedData
import javax.inject.Inject
import javax.inject.Singleton

@PerFeature
class Feature3ScopedDataImpl @Inject constructor() : iFeature4ScopedData {
    override fun getStringValue(): String {
        return "Feature 4 is Implementing this"
    }
}