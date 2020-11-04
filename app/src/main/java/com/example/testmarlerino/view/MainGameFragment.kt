package com.example.testmarlerino.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testmarlerino.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainGameFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_game,container,false)
    }
}