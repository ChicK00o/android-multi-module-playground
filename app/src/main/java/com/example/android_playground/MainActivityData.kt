package com.example.android_playground

import android.arch.lifecycle.MutableLiveData
import com.example.core_utils.default
import com.example.core_utils.di.AppScope
import javax.inject.Inject

@AppScope
class MainActivityData @Inject constructor() {
    var mainText = MutableLiveData<String>().default("Hello World")
}