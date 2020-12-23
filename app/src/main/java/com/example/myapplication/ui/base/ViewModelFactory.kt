package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.api.ApiHelper
import com.example.myapplication.data.repository.NewsListRepositoryImpl
import com.example.myapplication.ui.newslist.viewmodel.NewsListViewModel
//import com.example.myapplication.ui.newslist.viewmodel.ParallelNewsListViewModel
//import com.example.myapplication.ui.newslist.viewmodel.SeriesNewsListViewModel


class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsListViewModel::class.java)) {
            return NewsListViewModel(NewsListRepositoryImpl(apiHelper)) as T
        }
//        if (modelClass.isAssignableFrom(SeriesNewsListViewModel::class.java)) {
//            return SeriesNewsListViewModel(NewsListRepositoryImpl(apiHelper)) as T
//        }
//        if (modelClass.isAssignableFrom(ParallelNewsListViewModel::class.java)) {
//            return ParallelNewsListViewModel(NewsListRepositoryImpl(apiHelper)) as T
//        }
        throw IllegalArgumentException("Unknown class name")
    }

}