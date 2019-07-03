package com.example.core_utils.di

import android.app.Activity
import dagger.android.DispatchingAndroidInjector

object SubComponentsInjectors {

    const val bundleKey = "INJECTOR"
    const val applicationKey = "APP"

    private var holder : MutableMap<String, DispatchingAndroidInjector<Activity>> = mutableMapOf()
    fun addAndroidActivityInjector(name : String, holdThis : DispatchingAndroidInjector<Activity>) {
        holder[name] = holdThis
    }

    fun getAndroidActivityInjector(name: String) : DispatchingAndroidInjector<Activity> {
        return holder[name]?:holder[applicationKey]!!
    }
}