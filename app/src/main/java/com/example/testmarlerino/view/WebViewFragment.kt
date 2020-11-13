package com.example.testmarlerino.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testmarlerino.MarlerinoWebClient
import com.example.testmarlerino.R
import com.example.testmarlerino.viewModel.WebViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_web_view.*
import java.util.*
import kotlin.collections.HashMap

@AndroidEntryPoint
class WebViewFragment:Fragment() {
    private val webViewModel: WebViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_web_view,container,false)
    }


    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView.settings.cacheMode= WebSettings.LOAD_CACHE_ELSE_NETWORK
        webView.settings.javaScriptEnabled=true
        webView.webViewClient=MarlerinoWebClient() // webClient
        webViewModel.solveCookie(webView)

        val headers: MutableMap<String, String> =
            HashMap()
        val lang: String = Locale.getDefault().language // for example, returns "ru"
        //lang="en" проверка
        headers["Accept-Language"] = lang // also tried "ru", "ru_RU", "ru;q=0.8,en;q=0.6", etc.


       // webView.loadUrl("https://policies.google.com/privacy?hl=$lang&fg=1",headers)
        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState)
        }
        else {
            webView.loadUrl("https://yandex.ru/")
        }





        webView.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if (webView != null) {
                        if (webView.canGoBack()) {
                            webView.goBack()
                        }
                        else {
                            findNavController().popBackStack()
                        }
                    }
                }
            }
            true
        }


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }





}