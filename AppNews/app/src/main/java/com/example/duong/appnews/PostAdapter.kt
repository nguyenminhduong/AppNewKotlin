package com.example.duong.appnews

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.duong.appnews.model.Post

class PostAdapter(private val mContext: Context,
    posts: List<Post>) : RecyclerView.Adapter<PostAdapter.BookViewHolder>() {
  val mPosts: List<Post> = posts

  inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val description: TextView = itemView.findViewById<TextView>(R.id.text_description)
    val category: TextView = itemView.findViewById<TextView>(R.id.text_category)
    val image: ImageView = itemView.findViewById<ImageView>(R.id.imgThumbnail)
    val title: TextView = itemView.findViewById<TextView>(R.id.text_title)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
    return BookViewHolder(view)
  }

  override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
    val book = mPosts[position]
    holder.title.text = book.mTitle
    holder.description.text = book.mDescription
    holder.category.text = book.mNameCa
    Glide.with(mContext).load(book.mImage).into(holder.image)
  }

  override fun getItemCount(): Int {
    return mPosts.size
  }
}