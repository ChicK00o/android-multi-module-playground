package com.example.feature3.di

import android.arch.lifecycle.ViewModel
import com.example.core_utils.di.ViewModelKey
import com.example.feature3.Feature3ActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(Feature3ActivityViewModel::class)
    internal abstract fun feature3ActivityViewModel(viewModel: Feature3ActivityViewModel): ViewModel
}