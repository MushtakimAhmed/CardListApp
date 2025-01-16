package com.ansari.cardlistapp.domain.di

import com.ansari.cardlistapp.data.repository.CardRepositoryImpl
import com.ansari.cardlistapp.domain.usecase.GetCardListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun cardListUseCaseProvider(repositoryImpl: CardRepositoryImpl): GetCardListUseCase {
        return GetCardListUseCase(repositoryImpl)
    }
}