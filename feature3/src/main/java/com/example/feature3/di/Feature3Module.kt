package com.example.feature3.di

import dagger.Module

@Module(includes = [
    ActivityModule::class
    ,ViewModelsModule::class
])
abstract class Feature3Module