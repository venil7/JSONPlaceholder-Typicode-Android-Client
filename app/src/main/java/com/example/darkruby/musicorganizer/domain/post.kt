package com.example.darkruby.musicorganizer.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Post {

    constructor(_userId: Int, _id: Int, _title: String, _body: String) {
        id = _id
        userId = _userId
        title = _title
        body = _body
    }

    @SerializedName("userId")
    @Expose
    var userId: Int = 0
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("body")
    @Expose
    var body: String? = null
}
