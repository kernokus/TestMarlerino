package com.example.testmarlerino.network


import com.example.a10augportfolio.network.catalogItemsPOJO
import retrofit2.http.GET
import retrofit2.http.Query


interface catalogRequest {
    @GET("?")
    suspend fun getScriptInfo(@Query("key") key: String,@Query("q") q: String,@Query("image_type") imageType: String,@Query("page") page: Int): catalogItemsPOJO
    }
