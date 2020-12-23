//package com.example.myapplication.ui.newslist.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.myapplication.data.model.News
//import com.example.myapplication.data.repository.NewsListRepository
//import com.example.myapplication.utils.Resource
//import kotlinx.coroutines.launch
//
//class SeriesNewsListViewModel(private val newsListRepository: NewsListRepository) : ViewModel() {
//
//    private val newsList = MutableLiveData<Resource<List<News>>>()
//
//    init {
//        fetchNews()
//    }
//
//    private fun fetchNews() {
//        viewModelScope.launch {
//            newsList.postValue(Resource.loading(null))
//            try {
//                val response = newsListRepository.getNews()
//                val moreResponse = newsListRepository.getMoreNews()
//                val allResponse = mutableListOf<News>()
//                allResponse.addAll(response)
//                allResponse.addAll(moreResponse)
//                newsList.postValue(Resource.success(allResponse))
//            } catch (e: Exception) {
//                newsList.postValue(Resource.error(e.toString(), null))
//            }
//        }
//    }
//
//    fun getNews(): LiveData<Resource<List<News>>> {
//        return newsList
//    }
//
//}