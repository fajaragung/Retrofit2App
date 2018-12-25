package com.mengsoftstudio.retrofit2app.rests

import com.mengsoftstudio.retrofit2app.models.UserPosting
import io.reactivex.Flowable
import retrofit2.http.GET

// https://jsonplaceholder.typicode.com/posts

interface ApiRepository {

    @GET("posts")
    fun getApiUserPost(): Flowable<List<UserPosting>>   // End point of post is JSON Array

}