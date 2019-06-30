package com.example.android_playground

import android.app.Application
import timber.log.Timber.DebugTree
import timber.log.Timber


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(DebugTree())

        Timber.tag("LifeCycles")
        Timber.d("Application Created")
    }
}