package com.duongnh.beertestdemo.di

import com.duongnh.beertestdemo.FakeGetBeersRepository
import com.duongnh.data.IRetrofitClient
import com.duongnh.data.repository.GetBeersRepository
import com.duongnh.domain.repository.IGetBeersRepository
import com.duongnh.domain.usecases.GetBeersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleTest{

    @Provides
    fun provideGetBeersRepository(): IGetBeersRepository = FakeGetBeersRepository()

    @Provides
    fun provideGetBeersUseCase(getBeersRepository: IGetBeersRepository) = GetBeersUseCase(getBeersRepository)

}