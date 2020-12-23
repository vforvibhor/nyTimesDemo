package com.example.myapplication.data.api

import com.example.myapplication.data.model.News
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("svc/mostpopular/v2/viewed/{days}.json?api-key=lZEfqM1hD5lgT06cQlqeFcccvYERFW9T")
    suspend fun getNews(@Path("days")days:String): News


}