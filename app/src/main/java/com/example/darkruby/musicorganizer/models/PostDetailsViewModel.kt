package com.example.darkruby.musicorganizer.models

import android.content.Context
import android.databinding.ObservableField
import android.util.Log
import com.example.darkruby.musicorganizer.adapters.CommentAdapter
import com.example.darkruby.musicorganizer.domain.Comment
import com.example.darkruby.musicorganizer.domain.Post
import com.example.darkruby.musicorganizer.services.NetworkService
import com.example.darkruby.musicorganizer.services.SchedulerProvider
import com.example.darkruby.musicorganizer.util.toast

class PostDetailsViewModel(val context: Context,
                           val schedulerProvider: SchedulerProvider,
                           val networkService: NetworkService) {
    val title = ObservableField<String>("")
    val body = ObservableField<String>("")
    val adapter = ObservableField<CommentAdapter>(CommentAdapter(context, listOf()))
    val api = networkService.getJSONApi()

    val postSched = schedulerProvider.getSchedulersForObservable<Post>()
    val commentsSched = schedulerProvider.getSchedulersForObservable<List<Comment>>()

    fun getPost(id: Int) {
        val postObs = api.getPost(id)
        val commentsObs = api.getComments(id)

        postSched(postObs).subscribe({
            title.set(it.title)
            body.set(it.body)
        }) {
            context.toast(it.message!!)
            Log.d("@@->", it.message)
        }

        commentsSched(commentsObs).subscribe({
            Log.d("@@->msgs", it.size.toString())
            adapter.set(CommentAdapter(context, it))
        }) {
            context.toast(it.message!!)
            Log.d("@@->", it.message)
        }
    }

}
