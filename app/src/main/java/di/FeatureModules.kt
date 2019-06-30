package di

import com.example.feature2.di.Feature2Module
import dagger.Module

@Module(includes = [Feature2Module::class])
abstract class FeatureModules