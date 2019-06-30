package com.example.feature4.di

import com.example.core_utils.di.PerActivity
import com.example.feature4.Feature4ScopedDataImpl
import com.example.feature4a.di.Feature4aModule
import com.example.feature4b.di.Feature4bModule
import com.example.feature4scope.iFeature4ScopedData
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [
    Feature4aModule::class
    ,Feature4bModule::class
])
class FeatureModules {
    @Provides
    fun getFeature4ScopeImpl(feature4ScopedData: Feature4ScopedDataImpl) : iFeature4ScopedData {
        return feature4ScopedData
    }
}