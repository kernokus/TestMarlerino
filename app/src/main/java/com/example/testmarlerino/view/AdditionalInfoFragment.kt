package com.example.testmarlerino.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testmarlerino.R

class AdditionalInfoFragment():Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val msg=requireArguments()
        val temp=msg.get("key1")
        Log.d("testAdd", temp.toString())
        return inflater.inflate(R.layout.fragment_addit_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }





}