package com.example.feature2.di

import dagger.Module

@Module(includes = [
    ActivityModule::class
    ,ViewModelsModule::class
])
abstract class Feature2Module