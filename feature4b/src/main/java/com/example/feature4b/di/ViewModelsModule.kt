package com.example.feature4b.di

import android.arch.lifecycle.ViewModel
import com.example.core_utils.di.ViewModelKey
import com.example.feature4b.Feature4bActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(Feature4bActivityViewModel::class)
    internal abstract fun feature4bActivityViewModel(viewModel: Feature4bActivityViewModel): ViewModel
}