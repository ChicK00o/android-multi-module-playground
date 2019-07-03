package com.example.feature4.di

import android.support.v7.app.AppCompatActivity
import com.example.core_utils.di.BaseActivityModule
import com.example.core_utils.di.ActivityScope
import com.example.feature4.Feature4Activity
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class Feature4ActivityModule {
    @Binds
    @ActivityScope
    internal abstract fun appCompatActivity(feature4Activity: Feature4Activity): AppCompatActivity
}