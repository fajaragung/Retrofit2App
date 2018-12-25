package com.mengsoftstudio.retrofit2app.contract

import com.mengsoftstudio.retrofit2app.models.UserPosting
import io.reactivex.Flowable

interface ApiRepositoryContract {

    fun getApiUserPost(): Flowable<List<UserPosting>>

}