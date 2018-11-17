package com.example.darkruby.musicorganizer.di

import com.example.darkruby.musicorganizer.models.PostDetailsViewModel
import com.example.darkruby.musicorganizer.services.NetworkService
import com.example.darkruby.musicorganizer.services.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class PostDetailsActivityModule {

    @Provides
    fun provideViewModel(schedulerProvider: SchedulerProvider, networkService: NetworkService) =
            PostDetailsViewModel(schedulerProvider, networkService)

}
