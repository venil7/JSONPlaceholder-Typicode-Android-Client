package com.example.darkruby.musicorganizer.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.databinding.DataBindingUtil
import android.view.ViewGroup
import com.example.darkruby.musicorganizer.BR
import com.example.darkruby.musicorganizer.R
import com.example.darkruby.musicorganizer.databinding.CommentItemBinding
import com.example.darkruby.musicorganizer.domain.Comment
import com.example.darkruby.musicorganizer.models.CommentItemViewModel

class CommentAdapter(private val context: Context, private val comments: List<Comment>) : RecyclerView.Adapter<CommentAdapter.BindingHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val commentBinding = DataBindingUtil.inflate<CommentItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.comment_item,
                parent,
                false)
        return BindingHolder(commentBinding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val commentBinding = holder.binding
        commentBinding.setVariable(BR.model, CommentItemViewModel(context, comments[position]))
    }

    override fun getItemCount() = comments.size

    class BindingHolder(val binding: CommentItemBinding)
        : RecyclerView.ViewHolder(binding.commentItemConstraintLayout)
}
