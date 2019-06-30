package di

import com.example.feature2.di.Feature2Module
import com.example.feature3.di.Feature3Module
import com.example.feature4.di.Feature4Module
import dagger.Module

@Module(includes = [
    Feature2Module::class
    ,Feature3Module::class
    ,Feature4Module::class
])
abstract class FeatureModules