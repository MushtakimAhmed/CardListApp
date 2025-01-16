package com.ansari.cardlistapp.data.network

import com.ansari.cardlistapp.data.model.CardModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/v2/creditCards")
    suspend fun getCardListAPI(@Query("_quantity") quantity: Int): CardModel
}