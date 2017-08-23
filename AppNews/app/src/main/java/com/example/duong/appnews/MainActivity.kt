package com.example.duong.appnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.duong.appnews.Service.API
import com.example.duong.appnews.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<Post>> {
  var mPosts: MutableList<Post> = mutableListOf()
  lateinit var recyclerview: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    recyclerview = findViewById(R.id.recyclerview)
    recyclerview.layoutManager = LinearLayoutManager(this)
    recyclerview.adapter=PostAdapter(applicationContext, mPosts)
    initData()
  }

  fun initData(){
    API.apiService.posts.enqueue(this)
  }
  override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
    if(response==null|| response.body()==null){
      return
    }
    mPosts.addAll(response.body()!!)
    recyclerview.adapter.notifyDataSetChanged()
  }

  override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
    Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show();
  }

}
