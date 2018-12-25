package com.mengsoftstudio.retrofit2app.rests

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

// https://jsonplaceholder.typicode.com/

class ApiService {

    companion object {

        fun create(): ApiRepository {

            val service = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return service.create(ApiRepository::class.java)

        }

    }

}