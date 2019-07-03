package com.example.feature4.di

import com.example.core_utils.di.PerActivity
import com.example.core_utils.di.PerFeature
import com.example.feature4.Feature4Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerFeature
    @ContributesAndroidInjector(modules = [
//        Feature4ActivityModule::class
//        ,
        FeatureModules::class])
    abstract fun contributefeature4ActivityInjector(): Feature4Activity

}