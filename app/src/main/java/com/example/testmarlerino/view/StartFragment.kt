package com.example.testmarlerino.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testmarlerino.R
import com.example.testmarlerino.viewModel.StartViewModel
import com.facebook.appevents.AppEventsLogger
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_start.*
import splitties.permissions.requestPermission


@AndroidEntryPoint
class StartFragment:Fragment() {
    private val startingViewModel: StartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startingViewModel.requestPermissionsInFragment(this)
        goToWebViewBtn.setOnClickListener {
            startingViewModel.addEventWebViewClick()
            findNavController().navigate(R.id.webViewFragment)
        }
        startGameBtn.setOnClickListener {
            startingViewModel.addEventGameClick()
            findNavController().navigate(R.id.mainGameFragment)
        }
        logSentFriendRequestEvent()

        startingViewModel.showFirstPush()
    }




    private fun logSentFriendRequestEvent() {
        //setAutoLogAppEventsEnabled(true)
        AppEventsLogger.newLogger(context).logEvent("testEvent")
    }

}