package com.duongnh.beertestdemo.di

import com.duongnh.beertestdemo.network.RetrofitClient
import com.duongnh.data.IRetrofitClient
import com.duongnh.data.repository.GetBeersRepository
import com.duongnh.domain.repository.IGetBeersRepository
import com.duongnh.domain.usecases.GetBeersUseCase
import com.duongnh.domain.usecases.IGetBeersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): IRetrofitClient = RetrofitClient()

    @Provides
    fun provideGetBeersRepository(retrofitClient: IRetrofitClient): IGetBeersRepository = GetBeersRepository(retrofitClient)

    @Provides
    @Singleton
    fun provideGetBeersUseCase(getBeersRepository: IGetBeersRepository): IGetBeersUseCase = GetBeersUseCase(getBeersRepository)

}