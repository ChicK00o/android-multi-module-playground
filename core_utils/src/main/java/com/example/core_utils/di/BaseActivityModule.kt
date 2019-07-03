package com.example.core_utils.di

import android.app.Activity
import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module


@Module
abstract class BaseActivityModule {
    @Binds
    @ActivityScope
    abstract fun activity(appCompatActivity: AppCompatActivity): Activity

    @Binds
    @ActivityScope
    abstract fun activityContext(activity: Activity): Context

    @Binds
    @ActivityScope
    abstract fun activityLifeCycleOwner(appCompatActivity: AppCompatActivity): LifecycleOwner
}