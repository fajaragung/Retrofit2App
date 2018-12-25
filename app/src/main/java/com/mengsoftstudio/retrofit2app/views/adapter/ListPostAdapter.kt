package com.mengsoftstudio.retrofit2app.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.retrofit2app.R
import com.mengsoftstudio.retrofit2app.models.UserPosting
import kotlinx.android.synthetic.main.adapter_list_posting.view.*

class ListPostAdapter(private val mListUserPost: List<UserPosting>?,
                      private val mContext: Context) : RecyclerView.Adapter<ListPostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListPostAdapter.ViewHolder =
            ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_list_posting, p0, false))

    override fun getItemCount(): Int =
            mListUserPost!!.size

    override fun onBindViewHolder(p0: ListPostAdapter.ViewHolder, p1: Int) {
        p0.bindUserPosting(mListUserPost!![p1])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindUserPosting(userPosting: UserPosting?) {

            itemView.titleOfUserPost.text = userPosting?.postTitle
            itemView.bodyOfUserPost.text = userPosting?.postBody

        }

    }

}