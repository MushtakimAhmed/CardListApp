package com.ansari.cardlistapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ansari.cardlistapp.Utils.Constant.CREDIT_CARD_COUNT
import com.ansari.cardlistapp.common.UiState
import com.ansari.cardlistapp.domain.usecase.GetCardListUseCase
import com.ansari.cardlistapp.presentation.state.CardListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CardListVewModel @Inject constructor(private val cardListUseCase: GetCardListUseCase) :
    ViewModel() {

    //_cardList is a Backing property
    private val _cardList = mutableStateOf(CardListState())
    val cardList: State<CardListState> get() = _cardList

    init {
       getCardList()
    }

    fun getCardList(){
        cardListUseCase.invoke(CREDIT_CARD_COUNT).onEach {
            when (it) {
                is UiState.Loading -> {
                    _cardList.value = CardListState(isLoading = true)
                }

                is UiState.Success -> {
                    _cardList.value = CardListState(data = it.data)
                }

                is UiState.Error -> {
                    _cardList.value = CardListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}