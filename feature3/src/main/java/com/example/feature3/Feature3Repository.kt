package com.example.feature3

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature3Repository @Inject constructor(
    feature3Data: Feature3Data
) {
    var mainText = feature3Data.mainTextfeature3
}