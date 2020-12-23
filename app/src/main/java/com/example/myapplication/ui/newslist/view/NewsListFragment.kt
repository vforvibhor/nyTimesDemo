package com.example.myapplication.ui.newslist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders.*
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.ViewModelFactory
import com.example.myapplication.data.api.ApiHelperImpl
import com.example.myapplication.data.api.RetrofitBuilder
import com.example.myapplication.data.model.Result
import com.example.myapplication.ui.newslist.adapter.NewsListAdapter
import com.example.myapplication.ui.newslist.viewmodel.NewsListViewModel
import com.example.myapplication.utils.Status
import kotlinx.android.synthetic.main.fragment_news_list.*
import kotlinx.android.synthetic.main.fragment_news_list.view.*


class NewsListFragment : Fragment() {


    private lateinit var newsListViewModel: NewsListViewModel
    private lateinit var adapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

        setupUI(view)
        setupViewModel()
        setupObserver()

        return view
    }


    private fun setupUI( view:View) {
       view.recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = NewsListAdapter(){item-> goToDetailFragment(view, item.url)}
        view.recyclerView.addItemDecoration(
            DividerItemDecoration(
                view.recyclerView.context,
                (view.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        view.recyclerView.adapter = adapter

        view.radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radioBtn1 ->{
                    newsListViewModel.callFeatchNews("1")
                }

                R.id.radioBtn2->{
                    newsListViewModel.callFeatchNews("7")
                }

                R.id.radioBtn3->{
                    newsListViewModel.callFeatchNews("30")
                }
            }
        })
    }

    private fun setupObserver() {
        newsListViewModel.newsList.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { newsList -> renderList(newsList.results) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(newsList: List<com.example.myapplication.data.model.Result>) {
        adapter.setNews(newsList)
    }

    private fun setupViewModel() {
        newsListViewModel = of(
            this,
            ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService))
        ).get(NewsListViewModel::class.java)
    }

    fun goToDetailFragment(view:View, url:String){
        val bundle = bundleOf("url" to url)
        Navigation.findNavController(view).navigate(R.id.action_newsListFragment_to_detailNewsFragment2, bundle)
    }


}