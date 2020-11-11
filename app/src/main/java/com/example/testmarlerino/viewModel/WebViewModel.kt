package com.example.testmarlerino.viewModel

import android.os.Build
import android.util.Log
import android.webkit.WebView
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel


class WebViewModel @ViewModelInject constructor(private val cookieManager: android.webkit.CookieManager): ViewModel() {

    fun solveCookie(webView:WebView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(webView, true)
        }
        else {
            cookieManager.setAcceptCookie(true)
        }
    }

    fun save(){
        val temp:String?=cookieManager.getCookie("https://yandex.ru/")
        if (temp != null) {
            Log.d("save",temp)
        }
    }
}