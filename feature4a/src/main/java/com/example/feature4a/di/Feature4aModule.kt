package com.example.feature4a.di

import dagger.Module

@Module(includes = [
    ActivityModule::class
    ,ViewModelsModule::class
])
abstract class Feature4aModule