package com.example.myapplication.ui.newslist.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemLayoutBinding

class NewsListAdapter (private val listener: (com.example.myapplication.data.model.Result) -> Unit): RecyclerView.Adapter<NewsListAdapter.DataViewHolder>() {

    private var newsList: List<com.example.myapplication.data.model.Result>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_layout,
            parent,
            false
        )
    )
    override fun getItemCount() = newsList?.size ?: 0

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        newsList?.let {
            holder.binding.news = it[position]
            holder.itemView.setOnClickListener { listener(newsList!!.get(position)) }
            holder.binding.executePendingBindings()
        }
    }

    fun setNews(newsList: List<com.example.myapplication.data.model.Result>) {
        this.newsList = newsList
        notifyDataSetChanged()

    }

    inner class DataViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}
