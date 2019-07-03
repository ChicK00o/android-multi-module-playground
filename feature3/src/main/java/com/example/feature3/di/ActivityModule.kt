package com.example.feature3.di

import com.example.core_utils.di.FeatureScope
import com.example.feature3.Feature3Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @FeatureScope
    @ContributesAndroidInjector(modules = arrayOf(
//        Feature3ActivityModule::class
//        ,
        FeatureModules::class
        ))
    abstract fun contributefeature3ActivityInjector(): Feature3Activity

}