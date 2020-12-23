package com.example.myapplication.data.repository

import com.example.myapplication.data.model.News

interface NewsListRepository {

    suspend fun getNews(days:String): News

}