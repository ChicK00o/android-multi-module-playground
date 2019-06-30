package com.example.feature4a

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature4aRepository @Inject constructor(
    feature4aData: Feature4aData
) {
    var mainText = feature4aData.mainTextfeature4a
}