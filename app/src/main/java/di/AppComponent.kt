package di

import com.example.android_playground.MainApplication
import com.example.feature4.di.Feature4Subcomponent
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
    ,FeatureModules::class
))
interface AppComponent : AndroidInjector<MainApplication> {
    fun feature4SubcomponentBuilder(): Feature4Subcomponent.Builder
}