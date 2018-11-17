package com.example.darkruby.musicorganizer.di

import android.content.Context
import com.example.darkruby.musicorganizer.AndroidApp
import com.example.darkruby.musicorganizer.services.NetworkService
import com.example.darkruby.musicorganizer.services.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider() =
            SchedulerProvider(Schedulers.io(), AndroidSchedulers.mainThread())

    @Provides
    @Singleton
    fun providesNetworkService(): NetworkService =
            NetworkService()

    @Provides
    @Singleton
    fun provideContext(application: AndroidApp): Context =
            application
}
