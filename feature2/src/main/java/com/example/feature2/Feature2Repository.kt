package com.example.feature2

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature2Repository @Inject constructor(
    feature2Data: Feature2Data
) {
    var mainText = feature2Data.mainTextFeature2
}