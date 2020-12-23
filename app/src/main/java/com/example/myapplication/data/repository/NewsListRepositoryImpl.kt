package com.example.myapplication.data.repository

import com.example.myapplication.data.api.ApiHelper


class NewsListRepositoryImpl(private val apiHelper: ApiHelper) : NewsListRepository {

    override suspend fun getNews(days:String) = apiHelper.getNews(days)

}