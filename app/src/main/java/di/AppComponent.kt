package di

import com.example.android_playground.MainApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidInjectionModule::class
    ,AndroidSupportInjectionModule::class
    ,ActivityModule::class
    ,ViewModelsModule::class
    ,AppModule::class
))
interface AppComponent : AndroidInjector<MainApplication>