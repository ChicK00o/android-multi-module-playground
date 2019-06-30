package com.example.feature4.di

import com.example.feature4a.di.Feature4aModule
import com.example.feature4b.di.Feature4bModule
import dagger.Module

@Module(includes = [
    Feature4aModule::class
    ,Feature4bModule::class
])
interface FeatureModules