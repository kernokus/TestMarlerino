package com.example.testmarlerino.viewModel

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testmarlerino.repo.NetworkRepo
import com.example.testmarlerino.repo.RoomRepo
import com.example.testmarlerino.room.itemCatalogs
import kotlinx.coroutines.launch

class CatalogViewModel @ViewModelInject constructor(val app:Application, val db: RoomRepo, val network: NetworkRepo, val sp:SharedPreferences):AndroidViewModel(app) {
    companion object{
        const val IS_A_FIRST_LOAD="is first load"
        const val NOT_FIRST="not a first"
    }
    var catalogLD: MutableLiveData<Collection<itemCatalogs>?> = MutableLiveData(null)



     fun getCatalog() {
        viewModelScope.launch {
            val catalog=db.getCatalog()
            Log.d("GameVM",catalog.toString())
            catalogLD.value=catalog
        }
    }
    fun loadCatalog() {
        if (isFirstLoad()) //загружаем только 1 раз
        {
            Log.d("LOAD","LOAD!!!!")
            viewModelScope.launch {
                val ourData=network.getCatalog()
                catalogLD.value=ourData
                Log.d("catalogData",ourData.toString())
                db.saveCatalogInDb(ourData)
            }
        }

    }

    private fun isFirstLoad():Boolean{
        return if(sp.getString(IS_A_FIRST_LOAD,"def")!= NOT_FIRST) {
            sp.edit().putString(IS_A_FIRST_LOAD, NOT_FIRST).apply()
            true
        } else false
    }

}