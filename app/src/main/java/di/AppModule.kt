package di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule(private val app : Application){
    @Singleton
    @Provides
    fun getApplication() : Application = app

    @Singleton
    @Provides
    @Named(NamedConstants.applicationContext)
    fun getApplicationContext() : Context = app.applicationContext

}