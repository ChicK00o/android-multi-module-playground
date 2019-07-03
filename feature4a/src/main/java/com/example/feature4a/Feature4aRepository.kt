package com.example.feature4a

import com.example.core_utils.di.PerFeature
import javax.inject.Inject
import javax.inject.Singleton

@PerFeature
class Feature4aRepository @Inject constructor(
    feature4aData: Feature4aData
) {
    var mainText = feature4aData.mainTextfeature4a
}