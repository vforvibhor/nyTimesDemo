package com.example.myapplication.ui.newslist.view

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_detail_news.view.*


class DetailNewsFragment : Fragment() {



  lateinit var detailprogressBar:ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_news, container, false)
        detailprogressBar = (view).findViewById(R.id.detailprogressBar)
        val url =arguments?.getString("url")
        view.wvShowNews.getSettings().setJavaScriptEnabled(true)
        setupWebView(view)
        view.wvShowNews.loadUrl(url!!)

        return view
    }

    private fun setupWebView(view:View) {

        val webViewClient: WebViewClient = object: WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                detailprogressBar.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                detailprogressBar.visibility = View.GONE
                super.onPageFinished(view, url)
            }
        }
        view.wvShowNews.webViewClient = webViewClient
    }

}