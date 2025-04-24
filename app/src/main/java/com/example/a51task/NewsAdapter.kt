package com.example.a51task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(
    private val newsList: List<News>,
    private val onClick: (News) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.newsImage)
        val title: TextView = view.findViewById(R.id.newsTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.title.text = news.title
        Glide.with(holder.view.context).load(news.imageUrl).into(holder.image)
        holder.view.setOnClickListener { onClick(news) }
    }

    override fun getItemCount(): Int = newsList.size
}
