package com.example.feature2.di

import android.arch.lifecycle.ViewModel
import com.example.core_utils.di.ViewModelKey
import com.example.feature2.Feature2ActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(Feature2ActivityViewModel::class)
    internal abstract fun feature2ActivityViewModel(viewModel: Feature2ActivityViewModel): ViewModel
}