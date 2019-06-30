package com.example.android_playground

import android.content.Context
import android.support.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import di.AppComponent
import di.AppModule
import di.DaggerAppComponent
import timber.log.Timber.DebugTree
import timber.log.Timber


class MainApplication : DaggerApplication() {

    private var applicationComponent: AppComponent? = null

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        @Suppress("DEPRECATION")
        if(applicationComponent == null)
            applicationComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
        return applicationComponent!!
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(DebugTree())

        Timber.tag("LifeCycles")
        Timber.d("Application Created")
    }
}