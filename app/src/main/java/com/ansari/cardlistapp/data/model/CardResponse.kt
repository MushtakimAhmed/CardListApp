package com.ansari.cardlistapp.data.model

import com.google.gson.annotations.SerializedName

data class CardModel(
    val status: String,
    val code: Int,
    val locale: String,
    val total: Int,
    @SerializedName("data")
    val cardItems: List<CardItem>
)