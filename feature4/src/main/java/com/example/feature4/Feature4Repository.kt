package com.example.feature4

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature4Repository @Inject constructor(
    feature4Data: Feature4Data
) {
    var mainText = feature4Data.mainTextfeature4
}