package com.mengsoftstudio.retrofit2app.contract

import com.mengsoftstudio.retrofit2app.models.UserPosting

interface UserPostingContract {

    interface View {

        fun showLoading()
        fun dataUserPosting(listPosting: List<UserPosting>?)
        fun hideLoading()

    }

    interface Presenter {

        fun getDataUserPosting()
        fun destroyFetchData()

    }

}