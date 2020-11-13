package com.example.testmarlerino.repo


import android.content.Context
import com.example.testmarlerino.room.AppDatabase
import com.example.testmarlerino.room.itemCatalogs
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent

class RoomRepo (val context: Context) {


    @InstallIn(ApplicationComponent::class)
    @EntryPoint
    interface HiltProviderEntryPoint{
        fun appDatabase(): AppDatabase
    }

    private val appDatabase=getAppDatabase()

    private fun getAppDatabase(): AppDatabase {
        val hiltEntryPoint=EntryPointAccessors.fromApplication(context, HiltProviderEntryPoint::class.java)
        return hiltEntryPoint.appDatabase()
    }

     suspend fun getCatalog(): Collection<itemCatalogs>? {
        return appDatabase.itemCatalogsDao()?.getAll()
    }

    suspend fun saveCatalogInDb(ourData: MutableList<itemCatalogs>) {
        appDatabase.itemCatalogsDao()?.insertAll(ourData)
    }
}