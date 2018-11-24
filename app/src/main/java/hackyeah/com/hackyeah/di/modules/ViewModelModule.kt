package com.brotherhood.gramatyka.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brotherhood.gramatyka.di.viewModelFactory.ViewModelFactory
import com.brotherhood.gramatyka.di.viewModelFactory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hackyeah.com.hackyeah.ui.MainActivityViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun mainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}