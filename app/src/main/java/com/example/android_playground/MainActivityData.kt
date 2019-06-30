package com.example.android_playground

import android.arch.lifecycle.MutableLiveData
import com.example.core_utils.default
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainActivityData @Inject constructor() {
    var mainText = MutableLiveData<String>().default("Hello World")
}