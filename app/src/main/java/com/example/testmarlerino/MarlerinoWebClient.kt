package com.example.testmarlerino

import android.webkit.WebView
import android.webkit.WebViewClient


class MarlerinoWebClient:WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

        if (view != null) {
            if (url != null) {
                view.loadUrl(url)
            }
        }
        return true
    }

}