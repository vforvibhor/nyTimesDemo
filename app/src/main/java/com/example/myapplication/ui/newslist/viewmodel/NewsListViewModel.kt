package com.example.myapplication.ui.newslist.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.News
import com.example.myapplication.data.repository.NewsListRepository
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.launch

class NewsListViewModel(private val newsListRepository: NewsListRepository) : ViewModel() {

   val newsList = MutableLiveData<Resource<News>>()

    init {
        fetchNews("1")
    }

     fun callFeatchNews(days:String){
        fetchNews(days)
    }

    private fun fetchNews(days:String) {
        viewModelScope.launch {
            newsList.postValue(Resource.loading(null))
            try {
                val response = newsListRepository.getNews(days)
                newsList.postValue(Resource.success(response))
            } catch (e: Exception) {
                newsList.postValue(Resource.error(e.toString(), null))
            }
        }
    }

}