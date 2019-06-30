package com.example.feature2.di

import android.support.v7.app.AppCompatActivity
import com.example.core_utils.di.BaseActivityModule
import com.example.core_utils.di.PerActivity
import com.example.feature2.Feature2Activity
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class Feature2ActivityModule {
    @Binds
    @PerActivity
    internal abstract fun appCompatActivity(feature2Activity: Feature2Activity): AppCompatActivity
}