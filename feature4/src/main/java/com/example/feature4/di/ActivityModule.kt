package com.example.feature4.di

import com.example.core_utils.di.PerActivity
import com.example.feature4.Feature4Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(Feature4ActivityModule::class))
    abstract fun contributefeature4ActivityInjector(): Feature4Activity

}