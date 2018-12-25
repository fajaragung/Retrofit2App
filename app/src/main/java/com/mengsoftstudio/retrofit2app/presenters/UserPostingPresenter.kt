package com.mengsoftstudio.retrofit2app.presenters

import android.util.Log
import com.mengsoftstudio.retrofit2app.contract.UserPostingContract
import com.mengsoftstudio.retrofit2app.models.UserPosting
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class UserPostingPresenter(private val mView: UserPostingContract.View,
                           private val apiRepositoryPresenter: ApiRepositoryPresenter) : UserPostingContract.Presenter {

    companion object {
        private const val TAG = "PostingPresenter"
    }

    // control activity fetching data
    private val compositeDisposable = CompositeDisposable()

    // this function for get data user posting from server
    override fun getDataUserPosting() {

        mView.showLoading()
        compositeDisposable.add(apiRepositoryPresenter.getApiUserPost()
                .observeOn(AndroidSchedulers.mainThread())  // showing data to UI
                .subscribeOn(Schedulers.io())   // get data on the background service
                .subscribeWith(object : ResourceSubscriber<List<UserPosting>>() {
                    override fun onComplete() {
                        mView.hideLoading()
                    }

                    override fun onNext(t: List<UserPosting>?) {
                        Log.d(TAG, "Fetch data from API: Success : $t")
                        mView.dataUserPosting(t)
                    }

                    override fun onError(t: Throwable?) {
                        Log.d(TAG, "Fetch data from API: Failed")
                        mView.hideLoading()
                        mView.dataUserPosting(Collections.emptyList())
                    }

                }))


    }

    // this function for destroy activity fetching data
    override fun destroyFetchData() {
        Log.d(TAG, "Fetch data from API: destroyed")
        compositeDisposable.dispose()   // destroy activity fetching data
    }

}