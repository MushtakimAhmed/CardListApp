package com.ansari.cardlistapp.domain.repository

import com.ansari.cardlistapp.data.model.CardModel

interface CardRepository {
    suspend fun getCardList(quantity: Int): CardModel
}