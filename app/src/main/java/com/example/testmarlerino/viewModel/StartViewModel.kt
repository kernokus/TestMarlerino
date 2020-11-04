package com.example.testmarlerino.viewModel


import android.os.Bundle
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.google.firebase.analytics.FirebaseAnalytics

class StartViewModel @ViewModelInject constructor(private val fa:FirebaseAnalytics):ViewModel() {



    fun addEventGameClick(){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.METHOD, "testMethod")
        fa.logEvent(FirebaseAnalytics.Event.LOGIN, bundle)

    }

    fun addEventWebViewClick(){
        val bundle=Bundle()
        bundle.putString("click","clickGotoWebView")
        fa.logEvent("TestEVENT",bundle)
    }


}