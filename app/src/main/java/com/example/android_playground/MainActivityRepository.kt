package com.example.android_playground

import com.example.core_utils.di.AppScope
import javax.inject.Inject

@AppScope
class MainActivityRepository @Inject constructor(
    mainActivityData: MainActivityData
) {
    var mainText = mainActivityData.mainText
}