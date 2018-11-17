package com.example.darkruby.musicorganizer.models

import android.content.Context
import android.databinding.ObservableField
import com.example.darkruby.musicorganizer.adapters.PostAdapter
import com.example.darkruby.musicorganizer.domain.Post
import com.example.darkruby.musicorganizer.services.NetworkService
import com.example.darkruby.musicorganizer.services.SchedulerProvider

data class MainActivityViewModel(
        val context: Context,
        val schedulerProvider: SchedulerProvider,
        val networkService: NetworkService) {

    val adapter: ObservableField<PostAdapter> = ObservableField(PostAdapter(context, listOf()))
    val sched by lazy { schedulerProvider.getSchedulersForObservable<List<Post>>() }

    init {
        val allPostsObs = networkService.getJSONApi().getAllPosts()
        sched(allPostsObs).subscribe { adapter.set(PostAdapter(context, it)) }
    }
}
