package com.example.darkruby.musicorganizer

import android.app.Activity
import android.app.Application
import com.example.darkruby.musicorganizer.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AndroidApp @Inject constructor(): Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector:
            DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> =
            activityDispatchingAndroidInjector
}
