package com.example.feature4.di

import com.example.core_utils.di.PerActivity
import com.example.core_utils.di.PerFeature
import dagger.Subcomponent


@PerFeature
@Subcomponent(modules = [
//    FeatureModules::class
])
abstract class Feature4Subcomponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): Feature4Subcomponent
    }
}