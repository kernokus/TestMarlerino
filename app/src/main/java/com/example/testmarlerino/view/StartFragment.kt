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
        goToWebViewBtn.setOnClickListener {
            startingViewModel.addEventWebViewClick()
            findNavController().navigate(R.id.webViewFragment)
        }
        startGameBtn.setOnClickListener {
            startingViewModel.addEventGameClick()
            findNavController().navigate(R.id.mainGameFragment)
        }

            //  context?.let { generateSSHKey(it) }
        logSentFriendRequestEvent()
        startingViewModel.showFirstPush()
    }


//    @SuppressLint("PackageManagerGetSignatures")
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun generateSSHKey(context: Context){
//        try {
//            val info = context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_SIGNATURES)
//            for (signature in info.signatures) {
//                val md = MessageDigest.getInstance("SHA")
//                md.update(signature.toByteArray())
//                val hashKey = String(Base64.getEncoder().encode(md.digest()))
//                Log.i("AppLog", "key:$hashKey=")
//            }
//        } catch (e: Exception) {
//            Log.e("AppLog", "error:", e)
//        }
//
//    }

    fun logSentFriendRequestEvent() {
        //setAutoLogAppEventsEnabled(true)
        AppEventsLogger.newLogger(context).logEvent("testEvent")
    }

}