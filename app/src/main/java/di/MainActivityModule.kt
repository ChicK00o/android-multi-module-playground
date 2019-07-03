package di

import android.support.v7.app.AppCompatActivity
import com.example.android_playground.MainActivity
import dagger.Binds
import dagger.Module
import com.example.core_utils.di.BaseActivityModule
import com.example.core_utils.di.ActivityScope

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class MainActivityModule {
    @Binds
    @ActivityScope
    internal abstract fun appCompatActivity(mainActivity: MainActivity): AppCompatActivity
}