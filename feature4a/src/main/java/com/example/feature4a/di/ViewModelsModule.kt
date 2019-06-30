package com.example.feature4a.di

import android.arch.lifecycle.ViewModel
import com.example.core_utils.di.ViewModelKey
import com.example.feature4a.Feature4aActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(Feature4aActivityViewModel::class)
    internal abstract fun feature4aActivityViewModel(viewModel: Feature4aActivityViewModel): ViewModel
}