package com.example.darkruby.musicorganizer

import android.os.Bundle
import com.example.darkruby.musicorganizer.models.MainActivityViewModel
import com.example.darkruby.musicorganizer.models.PostDetailsViewModel
import dagger.android.DaggerActivity
import javax.inject.Inject

class PostDetailsActivity : DaggerActivity() {

    @Inject
    lateinit var model: PostDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
    }
}
