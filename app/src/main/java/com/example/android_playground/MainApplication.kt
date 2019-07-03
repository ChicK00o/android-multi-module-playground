package com.example.android_playground

import android.content.Context
import android.support.multidex.MultiDex
import com.example.core_utils.di.CoreDaggerApplication
import dagger.android.AndroidInjector
import di.AppComponent
import di.AppModule
import di.DaggerAppComponent
import timber.log.Timber.DebugTree
import timber.log.Timber


class MainApplication : CoreDaggerApplication() {

    private var applicationComponent: AppComponent? = null

    override fun applicationInjector(): AndroidInjector<out CoreDaggerApplication> {
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