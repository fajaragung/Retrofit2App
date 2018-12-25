package com.mengsoftstudio.retrofit2app.presenters

import com.mengsoftstudio.retrofit2app.contract.ApiRepositoryContract
import com.mengsoftstudio.retrofit2app.models.UserPosting
import com.mengsoftstudio.retrofit2app.rests.ApiRepository
import io.reactivex.Flowable

class ApiRepositoryPresenter(private val apiRepository: ApiRepository) : ApiRepositoryContract {

    // create function of interface api repository for get data
    override fun getApiUserPost(): Flowable<List<UserPosting>> =
            apiRepository.getApiUserPost()

}