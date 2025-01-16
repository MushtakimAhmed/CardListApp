package com.ansari.cardlistapp.presentation.state

import com.ansari.cardlistapp.data.model.CardModel

data class CardListState(
    val isLoading: Boolean = false,
    var data: CardModel? = null,
    var error: String = ""
)