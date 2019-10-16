package com.example.retrofitwithkotlindaggermvvm.di.components

import com.example.retrofitwithkotlindaggermvvm.SampleApp
import com.example.retrofitwithkotlindaggermvvm.di.modules.ActivityBindingModule
import com.example.retrofitwithkotlindaggermvvm.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, ActivityBindingModule::class,NetworkModule::class])
interface AppComponent : AndroidInjector<SampleApp>