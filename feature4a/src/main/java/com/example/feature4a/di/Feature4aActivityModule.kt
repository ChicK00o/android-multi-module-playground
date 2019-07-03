package com.example.feature4a.di

import android.support.v7.app.AppCompatActivity
import com.example.core_utils.di.BaseActivityModule
import com.example.core_utils.di.ActivityScope
import com.example.feature4a.Feature4aActivity
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class Feature4aActivityModule {
    @Binds
    @ActivityScope
    internal abstract fun appCompatActivity(feature4aActivity: Feature4aActivity): AppCompatActivity
}