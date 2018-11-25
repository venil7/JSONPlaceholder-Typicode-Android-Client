package com.example.darkruby.musicorganizer

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.darkruby.musicorganizer.databinding.ActivityPostDetailsBinding
import com.example.darkruby.musicorganizer.domain.Post
import com.example.darkruby.musicorganizer.models.PostDetailsViewModel
import dagger.android.DaggerActivity
import javax.inject.Inject


class PostDetailsActivity : DaggerActivity() {

    @Inject
    lateinit var model: PostDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val postId = intent.getIntExtra("POST_ID", 0)

        val binding: ActivityPostDetailsBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_post_details)

        binding.setVariable(BR.model, model)
        binding.executePendingBindings()

        binding.recyclerViewComments.layoutManager =
                LinearLayoutManager(this)

        model.getPost(postId)
    }
}
