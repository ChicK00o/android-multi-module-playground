package di

import com.example.android_playground.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.example.core_utils.di.PerActivity


@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun contributeMainActivityInjector(): MainActivity

}