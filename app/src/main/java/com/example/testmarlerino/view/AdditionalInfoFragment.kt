package com.example.testmarlerino.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.testmarlerino.R
import kotlinx.android.synthetic.main.fragment_addit_info.*

class AdditionalInfoFragment:Fragment() {
    lateinit var array: ArrayList<String?>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val msg=requireArguments()
        val temp=msg.get("key1")
        array= temp as ArrayList<String?>
        Log.d("testAdd", temp.toString())
        return inflater.inflate(R.layout.fragment_addit_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(array[3]).into(mainImage)
        tagsTV.text="Tags: ${array[2]}"
        likesTV.text="Number of likes:${array[1]}"
    }





}