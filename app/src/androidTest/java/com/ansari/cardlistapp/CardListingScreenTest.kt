package com.ansari.cardlistapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.ansari.cardlistapp.common.UiState
import com.ansari.cardlistapp.data.model.CardItem
import com.ansari.cardlistapp.data.model.CardModel
import com.ansari.cardlistapp.data.network.ApiService
import com.ansari.cardlistapp.data.repository.CardRepositoryImpl
import com.ansari.cardlistapp.domain.usecase.GetCardListUseCase
import com.ansari.cardlistapp.presentation.screens.CardListingScreen
import com.ansari.cardlistapp.presentation.viewmodel.CardListVewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CardListingScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var mockCardInfo: CardModel
    private lateinit var apiService: ApiService
    private lateinit var fakeRepository: CardRepositoryImpl
    private lateinit var getCardListUseCase: GetCardListUseCase


    @Before
    fun setUp() {
        mockCardInfo = CardModel(
            status = "status", code = 200, locale = "locale", total = 1,
            cardItems = listOf(
                CardItem(
                    type = "Visa", number = "1234567890123456",
                    "12/25", owner = "John"
                )
            )
        )
        apiService = object : ApiService {
            override suspend fun getCardListAPI(quantity: Int): CardModel {
                return mockCardInfo
            }
        }

        fakeRepository = CardRepositoryImpl(apiService)
        getCardListUseCase = GetCardListUseCase(fakeRepository)

    }


    @Test
    fun testSuccessState() {
        composeTestRule.setContent {
            CardListingScreen(viewModel = CardListVewModel(getCardListUseCase).apply {
                this.cardList.value.data = UiState.Success(mockCardInfo) as CardModel
            })
        }

        // Verify card details are displayed
        composeTestRule.onNodeWithText("Card Number: 1234567890123456").assertIsDisplayed()
        composeTestRule.onNodeWithText("Expiry Date: 12/25").assertIsDisplayed()
        composeTestRule.onNodeWithText("Card Type: Visa").assertIsDisplayed()
        composeTestRule.onNodeWithText("Owner Name: John").assertIsDisplayed()
    }
}