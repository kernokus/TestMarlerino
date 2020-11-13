package com.example.testmarlerino.viewModel


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.coroutines.launch
import splitties.permissions.requestPermission

class StartViewModel @ViewModelInject constructor(private val fa:FirebaseAnalytics):ViewModel() {



    fun showFirstPush(){
        val bundle=Bundle()
        bundle.putString("click","clickStartApp")
        fa.logEvent("clickStartApp",bundle)
    }

    fun addEventGameClick(){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.METHOD, "testMethod")
        fa.logEvent("ClickGame", bundle)

    }

    fun addEventWebViewClick(){
        val bundle=Bundle()
        bundle.putString("click","clickGotoWebView")
        fa.logEvent("TestEVENTWebViewClick",bundle)
    }

    fun requestPermissionsInFragment(fragment: Fragment) {
        viewModelScope.launch {
            //fragment.requestPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            //fragment.requestPermission(android.Manifest.permission.WAKE_LOCK)
            //fragment.requestPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
        }
    }


}