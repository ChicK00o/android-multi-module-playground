package com.example.feature2

import com.example.core_utils.di.AppScope
import javax.inject.Inject

@AppScope
class Feature2Repository @Inject constructor(
    feature2Data: Feature2Data
) {
    var mainText = feature2Data.mainTextFeature2
}