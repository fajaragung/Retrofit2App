package com.mengsoftstudio.retrofit2app.models

import com.google.gson.annotations.SerializedName

data class UserPosting (

        @SerializedName("id") val postId: String?,
        @SerializedName("title") val postTitle: String?,
        @SerializedName("body") val postBody: String?
)