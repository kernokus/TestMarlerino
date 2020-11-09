package com.example.testmarlerino.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.testmarlerino.MarlerinoWebClient
import com.example.testmarlerino.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_web_view.*

@AndroidEntryPoint
class WebViewFragment:Fragment() {

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
        webView.loadUrl("https://yandex.ru/")
        webView.settings.javaScriptEnabled=true
        webView.webViewClient=MarlerinoWebClient() // webClient


        webView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action === KeyEvent.ACTION_DOWN) {
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
        })


    }










}