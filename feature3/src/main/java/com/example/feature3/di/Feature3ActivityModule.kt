package com.example.feature3.di

import android.support.v7.app.AppCompatActivity
import com.example.core_utils.di.BaseActivityModule
import com.example.core_utils.di.ActivityScope
import com.example.feature3.Feature3Activity
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class Feature3ActivityModule {
    @Binds
    @ActivityScope
    internal abstract fun appCompatActivity(feature3Activity: Feature3Activity): AppCompatActivity
}