package com.example.darkruby.musicorganizer.di

import android.content.Context
import com.example.darkruby.musicorganizer.AndroidApp
import com.example.darkruby.musicorganizer.models.MainActivityViewModel
import com.example.darkruby.musicorganizer.services.NetworkService
import com.example.darkruby.musicorganizer.services.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(context: Context, schedulerProvider: SchedulerProvider, networkService: NetworkService) =
            MainActivityViewModel(context, schedulerProvider, networkService)

}
