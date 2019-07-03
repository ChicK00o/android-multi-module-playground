package di

import com.example.android_playground.MainApplication
import com.example.core_utils.di.AppScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(modules = arrayOf(
    AndroidInjectionModule::class
    ,AndroidSupportInjectionModule::class
    ,ActivityModule::class
    ,ViewModelsModule::class
    ,AppModule::class
    ,FeatureModules::class
))
interface AppComponent : AndroidInjector<MainApplication>