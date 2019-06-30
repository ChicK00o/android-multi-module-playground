package com.example.feature4b.di

import dagger.Module

@Module(includes = [
    ActivityModule::class
    ,ViewModelsModule::class
])
abstract class Feature4bModule