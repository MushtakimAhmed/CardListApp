package com.ansari.cardlistapp.data.di

import com.ansari.cardlistapp.Utils.Constant.BASE_URL
import com.ansari.cardlistapp.data.network.ApiService
import com.ansari.cardlistapp.data.repository.CardRepositoryImpl
import com.ansari.cardlistapp.domain.repository.CardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providerRepositoryImpl(apiService: ApiService): CardRepository {
        return CardRepositoryImpl(apiService)
    }

}