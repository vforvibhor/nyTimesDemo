package com.example.myapplication.ui.newslist.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.ui.newslist.adapter.NewsListAdapter
import com.example.myapplication.ui.newslist.viewmodel.NewsListViewModel


class NewsListActivity : AppCompatActivity() {

//    private lateinit var newsListViewModel: NewsListViewModel
//    private lateinit var adapter: NewsListAdapter
     lateinit var navController :NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.news_nav_host_fragment)
    }


}
