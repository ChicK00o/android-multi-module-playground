package com.example.feature4b

import com.example.core_utils.di.PerFeature
import javax.inject.Inject
import javax.inject.Singleton

@PerFeature
class Feature4bRepository @Inject constructor(
    feature4bData: Feature4bData
) {
    var mainText = feature4bData.mainTextfeature4b
}