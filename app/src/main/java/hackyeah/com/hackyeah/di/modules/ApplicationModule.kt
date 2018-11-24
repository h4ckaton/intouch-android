package com.brotherhood.gramatyka.di.modules

import dagger.Module
import dagger.Provides
import hackyeah.com.hackyeah.util.BaseApplication
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class ApplicationModule(private val application: BaseApplication) {
    @Provides
    @Singleton
    fun provideApplication() = application
}