package com.example.feature4b.di

import android.support.v7.app.AppCompatActivity
import com.example.core_utils.di.BaseActivityModule
import com.example.core_utils.di.PerActivity
import com.example.feature4b.Feature4bActivity
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class Feature4bActivityModule {
    @Binds
    @PerActivity
    internal abstract fun appCompatActivity(feature4bActivity: Feature4bActivity): AppCompatActivity
}