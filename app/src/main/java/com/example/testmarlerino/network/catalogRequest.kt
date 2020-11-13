package com.example.testmarlerino.network


import retrofit2.http.GET
import retrofit2.http.Query


interface catalogRequest {
    @GET("?")
    suspend fun getScriptInfo(@Query("key") key: String,@Query("q") q: String,@Query("image_type") imageType: String,@Query("page") page: Int): catalogItemsPOJO
    }
