package com.ansari.cardlistapp.data.repository

import com.ansari.cardlistapp.data.model.CardModel
import com.ansari.cardlistapp.data.network.ApiService
import com.ansari.cardlistapp.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(private val apiService: ApiService) : CardRepository {

    override suspend fun getCardList(quantity: Int): CardModel {
        return apiService.getCardListAPI(quantity)
    }
}