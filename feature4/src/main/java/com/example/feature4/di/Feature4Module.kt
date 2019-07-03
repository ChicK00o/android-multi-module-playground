package com.example.feature4.di

import dagger.Module

@Module(includes = [
    ActivityModule::class
    ,ViewModelsModule::class
])
abstract class Feature4Module