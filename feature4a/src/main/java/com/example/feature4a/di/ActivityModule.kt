package com.example.feature4a.di

import com.example.core_utils.di.PerActivity
import com.example.feature4a.Feature4aActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(Feature4aActivityModule::class))
    abstract fun contributefeature4aActivityInjector(): Feature4aActivity

}