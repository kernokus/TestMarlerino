package com.example.testmarlerino

import android.webkit.WebView
import android.webkit.WebViewClient


class MarlerinoWebClient:WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        //1 option
        // getApplicationContext().startActivity(
        // new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        if (view != null) {
            if (url != null) {
                view.loadUrl(url)
            }
        }
        return true
    }

}