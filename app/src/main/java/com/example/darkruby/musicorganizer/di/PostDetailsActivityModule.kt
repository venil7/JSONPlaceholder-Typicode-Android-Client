package com.example.darkruby.musicorganizer.di

import android.content.Context
import com.example.darkruby.musicorganizer.models.PostDetailsViewModel
import com.example.darkruby.musicorganizer.services.NetworkService
import com.example.darkruby.musicorganizer.services.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class PostDetailsActivityModule {

    @Provides
    fun provideViewModel(context: Context, schedulerProvider: SchedulerProvider, networkService: NetworkService) =
            PostDetailsViewModel(context, schedulerProvider, networkService)

}
