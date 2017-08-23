package com.example.duong.appnews.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object API {
  private var retrofit: Retrofit? = null
  val apiService: APIService
    get() {
      if (retrofit == null) {
        retrofit = Retrofit.Builder()
            .baseUrl("http://dev.2dev4u.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
      }
      return retrofit!!.create(APIService::class.java)
    }
}
