package com.example.feature3.di

import com.example.core_utils.di.PerActivity
import com.example.feature3.Feature3Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(Feature3ActivityModule::class))
    abstract fun contributefeature3ActivityInjector(): Feature3Activity

}