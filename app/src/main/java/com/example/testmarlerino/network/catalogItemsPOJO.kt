package com.example.testmarlerino.network

import androidx.room.Entity
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity
class catalogItemsPOJO {
    @SerializedName("total")
    @Expose
    var total: Int? = null

    @SerializedName("totalHits")
    @Expose
    var totalHits: Int? = null

    @SerializedName("hits")
    @Expose
    var hits: List<HitPOJO>? = null

}