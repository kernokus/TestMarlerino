package com.example.testmarlerino.room

import androidx.room.*

@Dao
interface ItemCatalogDAO {
    @Query("SELECT * FROM itemCatalogs")
    suspend fun getAll(): List<itemCatalogs>?

    @Insert
    suspend fun insertAll(users: List<itemCatalogs>)
    @Insert
    suspend fun insert(item: itemCatalogs?)

    @Update
    suspend fun update(item: itemCatalogs?)

    @Delete
    suspend fun delete(item: itemCatalogs?)



}