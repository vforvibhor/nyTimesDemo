package com.example.myapplication.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.R


@BindingAdapter("image")
fun loadImage(itemView: ImageView, url: String?) {
    Glide.with(itemView.context)
                .load(url)
                .placeholder(R.drawable.ic_account)
                .circleCrop()
                .into(itemView)
}

