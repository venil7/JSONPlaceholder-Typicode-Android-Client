package com.example.darkruby.musicorganizer.models

import android.content.Context
import com.example.darkruby.musicorganizer.domain.Post
import com.example.darkruby.musicorganizer.util.toast

data class PostItemViewModel(val context: Context, val post: Post) {
//    fun onClick() {
//        context.toast("post number ${post.id}")
//    }
}
