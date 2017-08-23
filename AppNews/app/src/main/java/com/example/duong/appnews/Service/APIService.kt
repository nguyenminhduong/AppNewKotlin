package com.example.duong.appnews.Service

import com.example.duong.appnews.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
  @get:GET("/news/api.php?latest_news=10")
  val posts: Call<List<Post>>
}
