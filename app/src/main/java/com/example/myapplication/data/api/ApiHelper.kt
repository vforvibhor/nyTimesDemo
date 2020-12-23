package com.example.myapplication.data.api

import com.example.myapplication.data.model.News

interface ApiHelper {

    suspend fun getNews(days:String): News


}