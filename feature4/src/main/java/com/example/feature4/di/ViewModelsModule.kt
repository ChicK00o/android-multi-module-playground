package com.example.feature4.di

import android.arch.lifecycle.ViewModel
import com.example.core_utils.di.ViewModelKey
import com.example.feature4.Feature4ActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(Feature4ActivityViewModel::class)
    internal abstract fun feature4ActivityViewModel(viewModel: Feature4ActivityViewModel): ViewModel
}