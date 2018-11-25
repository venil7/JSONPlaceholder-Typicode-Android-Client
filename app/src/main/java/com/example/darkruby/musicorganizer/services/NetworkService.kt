package com.example.darkruby.musicorganizer.services

import com.example.darkruby.musicorganizer.domain.Comment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.darkruby.musicorganizer.domain.Post
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    fun getPost(@Path("id") id: Int): Observable<Post>

    @GET("/posts")
    fun getAllPosts(): Observable<List<Post>>

    @GET("/posts/{id}/comments")
    fun getComments(@Path("id") id: Int): Observable<List<Comment>>
}

class NetworkService {
    private val BASE_URL = "https://jsonplaceholder.typicode.com"
    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    private val api by lazy { retrofit.create(JSONPlaceHolderApi::class.java) }

    fun getJSONApi(): JSONPlaceHolderApi = api
}
