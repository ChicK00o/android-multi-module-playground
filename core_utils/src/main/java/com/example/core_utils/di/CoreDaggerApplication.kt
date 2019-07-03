package com.example.core_utils.di

import android.content.Intent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

abstract class CoreDaggerApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        SubComponentsInjectors.addAndroidActivityInjector(SubComponentsInjectors.applicationKey, activityInjector())
    }

    fun enRichIntent(intent: Intent) : Intent {
        return intent.putExtra(SubComponentsInjectors.bundleKey, SubComponentsInjectors.applicationKey)
    }

    abstract override fun applicationInjector(): AndroidInjector<out CoreDaggerApplication>
}