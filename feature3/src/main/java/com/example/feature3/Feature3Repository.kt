package com.example.feature3

import com.example.core_utils.di.AppScope
import javax.inject.Inject

@AppScope
class Feature3Repository @Inject constructor(
    feature3Data: Feature3Data
) {
    var mainText = feature3Data.mainTextfeature3
}