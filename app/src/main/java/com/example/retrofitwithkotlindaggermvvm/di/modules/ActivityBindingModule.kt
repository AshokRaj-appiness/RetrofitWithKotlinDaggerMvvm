package com.example.retrofitwithkotlindaggermvvm.di.modules

import com.example.retrofitwithkotlindaggermvvm.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun injectMainActivityInApplication():MainActivity

}