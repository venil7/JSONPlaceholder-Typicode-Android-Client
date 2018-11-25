package com.example.darkruby.musicorganizer.domain

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post  {
    @Expose
    @SerializedName("userId")
    var userId: String? = ""

    @Expose
    @SerializedName("id")
    var id: Int = 0

    @Expose
    @SerializedName("title")
    var title: String? = ""

    @Expose
    @SerializedName("body")
    var body: String? = ""
}
