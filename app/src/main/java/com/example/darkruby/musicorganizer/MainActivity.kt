package com.example.darkruby.musicorganizer

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.darkruby.musicorganizer.databinding.ActivityMainBinding
import com.example.darkruby.musicorganizer.models.MainActivityViewModel
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : DaggerActivity() {
    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var model: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.model, model)
        binding.executePendingBindings()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        model.getPosts()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
