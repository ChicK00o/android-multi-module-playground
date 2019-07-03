package com.example.feature3.di

import com.example.feature3.Feature3ScopedDataImpl
import com.example.feature4a.di.Feature4aModule
import com.example.feature4b.di.Feature4bModule
import com.example.feature4scope.iFeature4ScopedData
import dagger.Module
import dagger.Provides

@Module(includes = [
    Feature4aModule::class
    , Feature4bModule::class
])
class FeatureModules {
    @Provides
    fun getFeature4ScopeImpl(feature4ScopedData: Feature3ScopedDataImpl) : iFeature4ScopedData {
        return feature4ScopedData
    }
}