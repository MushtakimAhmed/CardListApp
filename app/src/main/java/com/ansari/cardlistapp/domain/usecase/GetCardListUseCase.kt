package com.ansari.cardlistapp.domain.usecase

import com.ansari.cardlistapp.common.UiState
import com.ansari.cardlistapp.data.model.CardModel
import com.ansari.cardlistapp.data.repository.CardRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCardListUseCase @Inject constructor(private val repositoryImpl: CardRepositoryImpl) {

    operator fun invoke(quantity: Int): Flow<UiState<CardModel>> = flow {
        emit(UiState.Loading())
        try {
            emit(UiState.Success(data = repositoryImpl.getCardList(quantity)))
        } catch (e: Exception) {
            emit(UiState.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}