package com.mengsoftstudio.retrofit2app.views.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.mengsoftstudio.retrofit2app.R
import com.mengsoftstudio.retrofit2app.contract.UserPostingContract
import com.mengsoftstudio.retrofit2app.extensions.gone
import com.mengsoftstudio.retrofit2app.extensions.visible
import com.mengsoftstudio.retrofit2app.models.UserPosting
import com.mengsoftstudio.retrofit2app.presenters.ApiRepositoryPresenter
import com.mengsoftstudio.retrofit2app.presenters.UserPostingPresenter
import com.mengsoftstudio.retrofit2app.rests.ApiService
import com.mengsoftstudio.retrofit2app.views.adapter.ListPostAdapter
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UserPostingContract.View {

    private lateinit var mPresenter: UserPostingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // throws exception
        RxJavaPlugins.setErrorHandler {}

        doRequest()

    }

    // this function for start request data from server
    private fun doRequest() {

        // instance
        val repository = ApiRepositoryPresenter(ApiService.create())
        mPresenter = UserPostingPresenter(this, repository)

        mPresenter.getDataUserPosting()

    }

    // this function for show progress bar
    override fun showLoading() {
        // this kotlin extensions
        progressView.visible()
        listUserPosting.gone()
    }

    // this function to provide data for show to UI
    override fun dataUserPosting(listPosting: List<UserPosting>?) {

        // kotlin extensions
        // set data to adapter then serve data to recycler view
        listUserPosting.layoutManager = LinearLayoutManager(this@MainActivity)
        listUserPosting.adapter = ListPostAdapter(listPosting, this@MainActivity)
        (listUserPosting.adapter as ListPostAdapter).notifyDataSetChanged()

    }

    // this function for hide progress bar
    override fun hideLoading() {
        // this kotlin extensions
        progressView.gone()
        listUserPosting.visible()
    }

}