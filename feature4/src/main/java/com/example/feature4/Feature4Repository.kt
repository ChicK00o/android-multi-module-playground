package com.example.feature4

import com.example.core_utils.di.AppScope
import javax.inject.Inject

@AppScope
class Feature4Repository @Inject constructor(
    feature4Data: Feature4Data
) {
    var mainText = feature4Data.mainTextfeature4
}