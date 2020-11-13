package com.example.testmarlerino.repo

import android.util.Log
import com.example.testmarlerino.network.HitPOJO
import com.example.testmarlerino.network.catalogRequest
import com.example.testmarlerino.room.itemCatalogs
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

class NetworkRepo {
    companion object {
        const val BASE_URL="https://pixabay.com/api/"
        const val API_KEY="17951668-b5172637b18686031bb7db33b"
    }


    private fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = (HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    }

    suspend fun getCatalog(): MutableList<itemCatalogs> {
    val items =mutableListOf<itemCatalogs>()
    var count=0
    val dataNetwork=getRetrofit().create(catalogRequest::class.java).getScriptInfo(
        API_KEY,"yellow","photo",1).hits
        Log.d("TAGS",dataNetwork.toString())
        if (dataNetwork != null) {
            while(count<dataNetwork.size) {
                items.add(hitPOJOinItemCatalog(dataNetwork[count]))
                count++
            }
        }
    return items
}

    private fun hitPOJOinItemCatalog(hitPOJO: HitPOJO?): itemCatalogs {
        return itemCatalogs(0,hitPOJO?.likes.toString(),hitPOJO?.tags.toString(),hitPOJO?.largeImageURL.toString(),hitPOJO?.webformatURL.toString())
    }


}