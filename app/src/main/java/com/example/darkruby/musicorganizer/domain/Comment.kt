package com.example.darkruby.musicorganizer.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comment {
    @SerializedName("postId")
    @Expose
    var postId: Int = 0
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("body")
    @Expose
    var body: String? = null
}
