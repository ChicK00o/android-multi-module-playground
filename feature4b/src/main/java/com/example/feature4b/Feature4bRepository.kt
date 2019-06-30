package com.example.feature4b

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature4bRepository @Inject constructor(
    feature4bData: Feature4bData
) {
    var mainText = feature4bData.mainTextfeature4b
}