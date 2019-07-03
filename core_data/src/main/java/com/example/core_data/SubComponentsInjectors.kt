package com.example.core_data

import android.app.Activity
import dagger.android.DispatchingAndroidInjector

object SubComponentsInjectors {

    private var holder : MutableMap<String, DispatchingAndroidInjector<Activity>> = mutableMapOf()
    fun addAndroidActivityInjector(name : String, holdThis : DispatchingAndroidInjector<Activity>) {
        holder[name] = holdThis
    }

    fun getAndroidActivityInjector(name: String) : DispatchingAndroidInjector<Activity> {
        return holder[name]!!
    }
}