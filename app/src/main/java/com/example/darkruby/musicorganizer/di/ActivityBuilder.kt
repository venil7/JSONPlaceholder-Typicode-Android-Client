package com.example.darkruby.musicorganizer.di

import com.example.darkruby.musicorganizer.MainActivity
import com.example.darkruby.musicorganizer.PostDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(
            MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(
            PostDetailsActivityModule::class))
    abstract fun bindPostDetailsActivity(): PostDetailsActivity
}
