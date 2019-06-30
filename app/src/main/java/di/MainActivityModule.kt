package di

import android.support.v7.app.AppCompatActivity
import com.example.android_playground.MainActivity
import dagger.Binds
import dagger.Module
import di.utils.BaseActivityModule
import di.utils.PerActivity

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class MainActivityModule {
    @Binds
    @PerActivity
    internal abstract fun appCompatActivity(mainActivity: MainActivity): AppCompatActivity
}