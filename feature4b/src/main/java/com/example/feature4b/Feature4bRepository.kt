package com.example.feature4b

import com.example.core_utils.di.FeatureScope
import javax.inject.Inject

@FeatureScope
class Feature4bRepository @Inject constructor(
    feature4bData: Feature4bData
) {
    var mainText = feature4bData.mainTextfeature4b
}