package com.example.feature2.di

import com.example.core_utils.di.PerActivity
import com.example.feature2.Feature2Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(Feature2ActivityModule::class))
    abstract fun contributeFeature2ActivityInjector(): Feature2Activity

}