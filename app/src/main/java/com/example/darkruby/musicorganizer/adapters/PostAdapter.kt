package com.example.darkruby.musicorganizer.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.darkruby.musicorganizer.databinding.PostItemBinding
import com.example.darkruby.musicorganizer.domain.Post
import android.view.LayoutInflater
import android.databinding.DataBindingUtil
import android.view.ViewGroup
import com.example.darkruby.musicorganizer.BR
import com.example.darkruby.musicorganizer.R
import com.example.darkruby.musicorganizer.models.PostItemViewModel

class PostAdapter(private val context: Context, private val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.BindingHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val postBinding = DataBindingUtil.inflate<PostItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.post_item,
                parent,
                false)
        return BindingHolder(postBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val postBinding = holder.binding
        postBinding.setVariable(BR.model, PostItemViewModel(holder.context, posts[position]))
    }

    override fun getItemCount() = posts.size

    class BindingHolder(val binding: PostItemBinding, val context: Context)
        : RecyclerView.ViewHolder(binding.postItemConstraintLayout)
}
