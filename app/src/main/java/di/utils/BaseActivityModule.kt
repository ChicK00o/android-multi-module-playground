package di.utils

import android.app.Activity
import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module


@Module
abstract class BaseActivityModule {
    @Binds
    @PerActivity
    internal abstract fun activity(appCompatActivity: AppCompatActivity): Activity

    @Binds
    @PerActivity
    internal abstract fun activityContext(activity: Activity): Context

    @Binds
    @PerActivity
    internal abstract fun activityLifeCycleOwner(appCompatActivity: AppCompatActivity): LifecycleOwner
}