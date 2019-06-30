package com.example.android_playground

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainActivityRepository @Inject constructor(
    mainActivityData: MainActivityData
) {
    var mainText = mainActivityData.mainText
}