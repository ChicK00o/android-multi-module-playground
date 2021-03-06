package com.example.feature4b.di

import com.example.core_utils.di.ActivityScope
import com.example.feature4b.Feature4bActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(Feature4bActivityModule::class))
    abstract fun contributefeature4bActivityInjector(): Feature4bActivity

}