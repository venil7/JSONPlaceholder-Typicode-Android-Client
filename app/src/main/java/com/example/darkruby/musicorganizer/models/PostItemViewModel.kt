package com.example.darkruby.musicorganizer.models

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import com.example.darkruby.musicorganizer.PostDetailsActivity
import com.example.darkruby.musicorganizer.domain.Post

data class PostItemViewModel(val context: Context, val post: Post) {
    fun onClick() {
        val intent = Intent(context, PostDetailsActivity::class.java).apply {
            putExtra("POST_ID", post.id)
        }
        startActivity(context, intent, null)
    }

}
