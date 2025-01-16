package com.ansari.cardlistapp

import com.ansari.cardlistapp.data.model.CardItem
import com.ansari.cardlistapp.data.model.CardModel
import com.ansari.cardlistapp.data.network.ApiService
import com.ansari.cardlistapp.data.repository.CardRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class CardRepositoryImplTest {

    // A mock version of the ApiService
    private val apiService = object : ApiService {
        override suspend fun getCardListAPI(quantity: Int): CardModel {
           return CardModel(status = "status", code = 200, locale = "locale", total = 1,
                cardItems = listOf(CardItem(type = "Visa", number = "1234567890123456",
                    "12/25", owner = "John"))
            )
        }
    }

    private val repository = CardRepositoryImpl(apiService)

    @Test
    fun testFetchCardInfoSuccess() = runBlocking {
        val expectedCardInfo =
            CardModel(status = "status", code = 200, locale = "locale", total = 1,
                cardItems = listOf(CardItem(type = "Visa", number = "1234567890123456",
                    "12/25", owner = "John"))
            )

        // Call the repository method
        val result = repository.getCardList(1)

        // Assert the results
        assertEquals(expectedCardInfo, result)
    }
}