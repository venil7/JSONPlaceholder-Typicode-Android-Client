package com.example.darkruby.musicorganizer.models

import com.example.darkruby.musicorganizer.services.NetworkService
import com.example.darkruby.musicorganizer.services.SchedulerProvider

class PostDetailsViewModel(val schedulerProvider: SchedulerProvider,
                           val networkService: NetworkService) {
    val api = networkService.getJSONApi()

    init {
//        val allPostsObs = networkService
//                .getJSONApi()
//                .getComments()
//        sched(allPostsObs)
//                .subscribe {
//                    Log.d("@@->", it.size.toString())
//                    adapter.set(PostAdapter(it))
//                }
    }

}
